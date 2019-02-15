package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class TrainerMapRepository implements TrainerRepository {

	private long id;

	@Inject
	private JSONUtil util;

	Map<Long, Trainer> trainerMap = new HashMap<Long, Trainer>();
	Trainer startTest = new Trainer(id++, "Test");

	
	
	
	@Override
	public String getAllTrainers() 
	{
		trainerMap.put(id, startTest);
		Trainer john = new Trainer(1l, "John");
		Trainer Richard = new Trainer(2l, "Richard");
		trainerMap.put(id++, john);
		trainerMap.put(id++, Richard);
		try {
			return "Success";
		} catch (Exception e) {
			return "fail";
		}
	}

	@Override
	public String getATrainer(Long id) {
		return "" + trainerMap.get(id);
	}

	@Override
	public String updateTrainer(String trainer, Long id) {
		deleteTrainer(id);
		createTrainer(trainer);
		return "trainer updated.";
	}

	@Override
	public String deleteTrainer(Long id) 
	{
		if (trainerMap.containsKey(id))
		{
		trainerMap.remove(id);
		return "trainer has been removed.";
		}
		else
		{
			return "fail";	
		}
		}

	@Override
	public String createTrainer(String trainer) {
		try {
			Trainer John = util.getObjectForJSON(trainer, Trainer.class);
			trainerMap.put(id++, John);
			return "Success";
		} catch (Exception o) 
		{
			System.out.println("" + trainer);
			return "Fail";
		}

	}
}
