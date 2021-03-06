package qa.com.ClassRoom;

import org.junit.Test;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.repository.TrainerDBRepository;
import com.qa.rest.JAXActivator;
import com.qa.rest.TrainerEndpoint;
import com.qa.util.JSONUtil;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
{
    
	@Test
	public void newtest()
	{
		new JSONUtil();
		new JAXActivator();
		TrainerEndpoint test = new TrainerEndpoint();
	}
    
    @Test
    public void trainer()
    {
    	Trainer john = new Trainer(null, null);
    	john.setClassroomId(2l);
    	john.setTrainerName("John");
    	john.getClassroomId();
    	john.getTrainerName();
    	john.setTrainees(null);
    	john.getTrainees();
    	Trainer matt = new Trainer();
    	Trainee simon = new Trainee();
    	simon.setTraineeId(4l);
    	simon.setTraineeName("Simon");
    	System.out.println(john.getTrainees());
    	matt.addtrainee(simon);
    	matt.removetrainee(simon);
    }
    
    @Test
    public void trainee()
    {
    	Trainee john = new Trainee(0, null);
    	Trainee john2 = new Trainee();
    	john2.setTraineeId(1l);
    	john2.setTraineeName("John Trainee");
    	john2.getTraineeId();
    	john2.getTraineeName();
    	
    }
    
    
}
