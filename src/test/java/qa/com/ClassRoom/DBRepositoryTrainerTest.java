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

import com.qa.persistence.domain.Trainer;
import com.qa.persistence.repository.TrainerDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBRepositoryTrainerTest

{
	@InjectMocks
	private TrainerDBRepository repoTrainer;

	@Mock
	private EntityManager manager;

	@Mock
	private EntityManager manager2;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"classroomId\":\"1l\",\"TrainerName\":\"John\"}]";

	private static final String MOCK_OBJECT = "{\"classroomId\":\"1l\",\"TrainerName\":\"John\"}";

	@Before
	public void setup() {
		repoTrainer.setManager(manager);
		util = new JSONUtil();
		repoTrainer.setUtil(util);
	}

	@Test
	public void testGetAllTrainers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainer> trainers = new ArrayList<Trainer>();
		trainers.add(new Trainer(1l, "John"));
		Mockito.when(query.getResultList()).thenReturn(trainers);
		System.out.println(repoTrainer.getAllTrainers());
	}

//	@Test
//	public void testCreateTrainer() {
//		String reply = repoTrainer.createTrainer(MOCK_OBJECT);
//		Assert.assertEquals(reply, "{\"message\": \"Trainer has been sucessfully added\"}");
//	}

	@Test
	public void testDeleteTrainer() {
		String reply = repoTrainer.deleteTrainer(1L);
		Assert.assertEquals(reply, "{\"message\": \"trainer sucessfully deleted\"}");
	}

//	@Test
//	public void testupdateTrainer() 
//	{
//		String reply = repoTrainer.updateTrainer(MOCK_OBJECT, 1l);
//		Assert.assertEquals(reply, "{\"message\": \"Trainer sucessfully updated\"}");
//	}
	
}
