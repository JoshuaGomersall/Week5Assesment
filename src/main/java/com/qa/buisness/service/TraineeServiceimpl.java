package com.qa.buisness.service;

import javax.inject.Inject;
import com.qa.persistence.repository.TrainerRepository;

public class TraineeServiceimpl implements TrainerService
{
	
	@Inject
	private TrainerRepository repo;
	

	public String addTrainer(String Trainer) 
	{
		return repo.createTrainer(Trainer);
	}

	public String getAllTrainers() {
		return repo.getAllTrainers();
	}

	public String getATrainer(Long id) {	
		return repo.getATrainer(id);
	}

	public String updateTrainer(String Trainer, Long id) {
		return repo.updateTrainer(Trainer, id);
	}

	public String deleteTrainer(Long id) {
		return repo.deleteTrainer(id);
	}
	
}
