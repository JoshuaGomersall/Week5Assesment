package com.qa.buisness.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TrainerRepository;

public class TrainerServiceimpl implements TrainerService
{
	
	@Inject
	private TrainerRepository repo;
	

	@Override
	public String addTrainer(String Trainer) 
	{
		return repo.createTrainer(Trainer);
	}

	@Override
	public String getAllTrainers() {
		return repo.getAllTrainers();
	}

	@Override
	public String getATrainer(Long id) {	
		return repo.getATrainer(id);
	}

	@Override
	public String updateTrainer(String Trainer, Long id) {
		return repo.updateTrainer(Trainer, id);
	}

	@Override
	public String deleteTrainer(Long id) {
		return repo.deleteTrainer(id);
	}
	
}