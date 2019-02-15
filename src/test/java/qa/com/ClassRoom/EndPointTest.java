package qa.com.ClassRoom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.buisness.service.TraineeService;
import com.qa.buisness.service.TrainerService;
import com.qa.rest.JAXActivator;
import com.qa.rest.TraineeEndpoint;
import com.qa.rest.TrainerEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class EndPointTest 
{
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	
	
	
	
	@InjectMocks
	private TrainerEndpoint endpointrainer;
	
	@InjectMocks
	private TraineeEndpoint endpointtrainee;

	@Mock
	private TrainerService servicetrainer;

	@Mock
	private TraineeService servicetrainee;
	
	@Before
	public void setup() {
		new JAXActivator();
		endpointtrainee.setService(servicetrainee);
		endpointrainer.setService(servicetrainer);
	}
	
	
	@Test
	public void testGetAll()
	{
		Mockito.when(servicetrainer.getAllTrainers()).thenReturn(MOCK_VALUE);
		Mockito.when(servicetrainee.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpointrainer.getAllTrainers());
		Assert.assertEquals(MOCK_VALUE, endpointtrainee.getAllTrainees());
	}
	
	@Test
	public void testGetA()
	{
		Mockito.when(servicetrainer.getATrainer(1l)).thenReturn(MOCK_VALUE);
		Mockito.when(servicetrainee.getATrainee(1l)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpointrainer.getATrainer(1l));
		Assert.assertEquals(MOCK_VALUE, endpointtrainee.getATrainee(1l));
	}
	
	@Test
	public void testCreateTrainer() {
		Mockito.when(servicetrainer.addTrainer(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpointrainer.addTrainer(MOCK_VALUE2));
		Mockito.verify(servicetrainer).addTrainer(MOCK_VALUE2);
	}
	
	@Test
	public void testCreateTrainee() {
		Mockito.when(servicetrainee.addTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpointtrainee.addTrainee(MOCK_VALUE2));
		Mockito.verify(servicetrainee).addTrainee(MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteTrainer() 
	{
		Mockito.when(servicetrainer.deleteTrainer(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpointrainer.deleteTrainer(1L));
		Mockito.verify(servicetrainer).deleteTrainer(1L);
	}
	
	@Test
	public void testDeleteTrainee() 
	{
		Mockito.when(servicetrainee.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpointtrainee.deleteTrainee(1L));
		Mockito.verify(servicetrainee).deleteTrainee(1L);
	}
	
}
