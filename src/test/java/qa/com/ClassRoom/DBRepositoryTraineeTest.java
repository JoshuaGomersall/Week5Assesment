package qa.com.ClassRoom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBRepositoryTraineeTest

{
	@InjectMocks
	private TraineeDBRepository repoTrainee;
	private TraineeDBRepository repotrainee;

	@Mock
	private EntityManager manager;

	@Mock
	private EntityManager manager2;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"classroomId\":\"1l\",\"traineeName\":\"John\"}]";

	private static final String MOCK_OBJECT = "{\"classroomId\":\"1l\",\"traineeName\":\"John\"}";

	@Before
	public void setup() {
		repoTrainee.setManager(manager);
		util = new JSONUtil();
		repoTrainee.setUtil(util);
	}

	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> Trainees = new ArrayList<Trainee>();
		Trainees.add(new Trainee(1l, "John"));
		Mockito.when(query.getResultList()).thenReturn(Trainees);
		System.out.println(repoTrainee.getAllTrainees());
	}

	@Test
	public void testCreateTrainee() {
		String reply = repoTrainee.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Trainee has been sucessfully added\"}");
	}

	@Test
	public void testDeleteTrainee() {
		String reply = repoTrainee.deleteTrainee(1L);
		Assert.assertEquals(reply, "{\"message\": \"Trainee sucessfully deleted\"}");
	}

	@Test
	public void testupdateTrainee() 
	{
		String reply = repoTrainee.updateTrainee(MOCK_OBJECT, 1l);
		Assert.assertEquals(reply, "{\"message\": \"Trainee sucessfully updated\"}");
	}
	
}
