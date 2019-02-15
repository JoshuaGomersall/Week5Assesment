package qa.com.ClassRoom;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.qa.persistence.repository.TraineeMapRepository;
import com.qa.persistence.repository.TrainerMapRepository;

public class MapTest 
{
	TraineeMapRepository repo;
	TrainerMapRepository repo2;
	
	
	@Before
	public void setup() 
	{
		repo = new TraineeMapRepository();
		repo2 = new TrainerMapRepository();
	}

	@Test
	public void addTraineeTest() 
	{
		repo.createTrainee("{\"id\":\"1l\",\"traineeName\":\"John\"}");
		repo2.createTrainer("{\"id\":\"1l\",\"traineeName\":\"John\"}");
	}

	@Test
	public void removeTraineeTest() 
	{
		repo.createTrainee("{\"id\":\"1l\",\"traineeName\":\"John\"}");
		repo.createTrainee("{\"id\":\"2l\",\"traineeName\":\"John\"}");
		repo.createTrainee("{\"id\":\"7l\",\"traineeName\":\"John\"}");
		repo.deleteTrainee(1l);
	}

	@Test
	public void remove2TraineeTestAnd1ThatDoesntExist() 
	{
		repo.createTrainee("{\"id\":\"0l\",\"traineeName\":\"John\"}");
		repo.createTrainee("{\"id\":\"4l\",\"traineeName\":\"John\"}");
	}

	@Test
	public void getall() {
		repo.getAllTrainees();
		repo2.getAllTrainers();
		repo.createTrainee("wdad");
		repo.deleteTrainee(1l);
		repo2.deleteTrainer(1l);
		repo.getATrainee(1l);
		repo2.getATrainer(1l);
	}
}
