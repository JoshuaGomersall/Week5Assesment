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
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TrainerDBRepository implements TrainerRepository
{
	@PersistenceContext(unitName = "primary") 
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllTrainers()
	{
		Query query = manager.createQuery("Select a FROM Trainer a");
		Collection<Trainer> Trainers = (Collection<Trainer>) query.getResultList();
		return util.getJSONForObject(Trainers);
	}
	
	public String getATrainer(Long id) 
	{
		return util.getJSONForObject(manager.find(Trainer.class, id));
	}
	
	
	@Transactional(REQUIRED)
	public String createTrainer(String trainer)
	{
		Trainer aTrainer = util.getObjectForJSON(trainer, Trainer.class);
		manager.persist(aTrainer);
		return "{\"message\": \"trainer has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainer(Long id) 
	{
		Trainer trainerinDB = util.getObjectForJSON(getATrainer(id) , Trainer.class);
		if (manager.contains(manager.find(Trainer.class, id)))
		{
			manager.remove(manager.find(Trainer.class, id));
		}
		return "{\"message\": \"trainer sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateTrainer(String Trainer, Long id) 
	{
		deleteTrainer(id);
		createTrainer(Trainer);
		return "{\"message\": \"Trainer sucessfully updated\"}";
	}
	
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
