package com.qa.buisness.service;

public interface TrainerService {
	// C
	String addTrainer(String Trainer);

	// R
	String getAllTrainers();

	String getATrainer(Long id);

	// U
	String updateTrainer(String Trainer, Long id);

	// D
	String deleteTrainer(Long id);

}
