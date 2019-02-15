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
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class TraineeMapRepository implements TraineeRepository {

	private long id;

	@Inject
	private JSONUtil util;

	Map<Long, Trainee> traineeMap = new HashMap<Long, Trainee>();
	Trainee startTest = new Trainee(id++, "Test");

	@Override
	public String getAllTrainees() {
		traineeMap.put(id, startTest);
		Trainee john = new Trainee(1l, "John");
		Trainee Richard = new Trainee(2l, "Richard");
		traineeMap.put(id++, john);
		traineeMap.put(id++, Richard);
		try {
			return "Success";
		} catch (Exception e) {
			return "fail";
		}
	}

	@Override
	public String getATrainee(Long id) {
		return "" + traineeMap.get(id);
	}

	@Override
	public String updateTrainee(String Trainee, Long id) {
		deleteTrainee(id);
		createTrainee(Trainee);
		return "Trainee updated.";
	}

	@Override
	public String deleteTrainee(Long id) {
		this.traineeMap.remove(id);
		return "Trainee has been removed.";
	}

	@Override
	public String createTrainee(String trainee) {
		try {
			Trainee John = util.getObjectForJSON(trainee, Trainee.class);
			traineeMap.put(id++, John);
			return "Success";
		} catch (Exception o) {
			return "Fail";
		}

	}
}
