package qa.com.ClassRoom;

import static org.junit.Assert.assertEquals;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
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
		assertEquals("Success",repo.createTrainee("{\"id\":\"1l\",\"traineeName\":\"John\"}"));
	}

	@Test
	public void add2TraineesTest() {
		assertEquals("Success",repo.createTrainee("{\"classroomId\":\"1l\",\"traineeName\":\"John\"}"));
		assertEquals("Success", repo.createTrainee("{\"classroomId\":\"1l\",\"traineeName\":\"John\"}"));
	}

	@Test
	public void removeTraineeTest() 
	{
		assertEquals("Trainee has been removed.", repo.deleteTrainee((long) 1));
		assertEquals("Trainee has been removed.", repo.deleteTrainee((long) 0));

	}

	@Test
	public void remove2TraineesTest() {
		assertEquals("Trainee has been removed.", repo.deleteTrainee((long) 1));
		assertEquals("Trainee has been removed.", repo.deleteTrainee((long) 0));
	}

	@Test
	public void remove2TraineeTestAnd1ThatDoesntExist() {
		assertEquals("Trainee has been removed.", repo.deleteTrainee((long) 0));
	}

	@Test
	public void getall() {
		repo.getAllTrainees();
		repo.createTrainee("wdad");
		repo.deleteTrainee(1l);
		repo.getATrainee(1l);
	}

	@Test
	public void jsonStringToTraineeConversionTest() 
	{
		
	}

	@Test
	public void TraineeConversionToJSONTest() {
	}

	@Test
	public void getCountForFirstNamesInTraineeWhenZeroOccurances() {
	}

	@Test
	public void getCountForFirstNamesInTraineeWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInTraineeWhenTwo() {
	}

}
