package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository
{
	@PersistenceContext(unitName = "primary") 
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllTrainees()
	{
		Query query = manager.createQuery("Select a FROM Trainee a");
		Collection<Trainee> Trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(Trainees);
	}
	
	public String getATrainee(Long id) 
	{
		return util.getJSONForObject(manager.find(Trainee.class, id));
	}
	
	
	@Transactional(REQUIRED)
	public String createTrainee(String Trainee)
	{
		Trainee aTrainee = util.getObjectForJSON(Trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) 
	{
		Trainee TraineeinDB = util.getObjectForJSON(getATrainee(id) , Trainee.class);
		if (manager.contains(manager.find(Trainee.class, id)))
		{
			manager.remove(manager.find(Trainee.class, id));
		}
		return "{\"message\": \"Trainee sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateTrainee(String Trainee, Long id) 
	{
		deleteTrainee(id);
		createTrainee(Trainee);
		return "{\"message\": \"Trainee sucessfully updated\"}";
	}
	
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
