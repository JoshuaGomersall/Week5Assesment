package qa.com.ClassRoom;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.qa.persistence.repository.TraineeMapRepository;

public class MapTest 
{
	TraineeMapRepository repo;

	@Before
	public void setup() 
	{
		repo = new TraineeMapRepository();
	}

	@Test
	public void addTraineeTest() 
	{
		repo.createTrainee("{\"id\":\"1l\",\"traineeName\":\"John\"}");
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
		repo.createTrainee("wdad");
		repo.deleteTrainee(1l);
		repo.getATrainee(1l);
	}
}
