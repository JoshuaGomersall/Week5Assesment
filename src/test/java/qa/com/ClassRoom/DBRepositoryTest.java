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
import com.qa.persistence.repository.TraineeDBRepository;
import com.qa.persistence.repository.TrainerDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBRepositoryTest

{
	@InjectMocks
	private TrainerDBRepository repotrainer;
	private TraineeDBRepository repotrainee;

	@Mock
	private EntityManager manager;

	@Mock
	private EntityManager manager2;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"classroomId\":\"1l\",\"trainerName\":\"John\"}]";

	private static final String MOCK_OBJECT = "{\"classroomId\":\"1l\",\"trainerName\":\"John\"}";

	@Before
	public void setup() {
		repotrainer.setManager(manager);
		util = new JSONUtil();
		repotrainer.setUtil(util);
	}

	@Test
	public void testGetAllTrainers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainer> Trainers = new ArrayList<Trainer>();
		Trainers.add(new Trainer(1l, "John"));
		Mockito.when(query.getResultList()).thenReturn(Trainers);
		System.out.println(repotrainer.getAllTrainers());
	}

	@Test
	public void testCreateTrainer() {
		String reply = repotrainer.createTrainer(MOCK_OBJECT);
	}

	@Test
	public void testDeleteTrainer() {
		String reply = repotrainer.deleteTrainer(1L);
		String reply2 = repotrainer.deleteTrainer(2L);
	}
	
	@Test
	public void testupdateTrainer() 
	{
		String reply = repotrainer.updateTrainer(MOCK_OBJECT, 1l);
		Assert.assertEquals(reply, "{\"message\": \"Trainer sucessfully updated\"}");
	}

}
