package com.qa.persistence.repository;

public interface TrainerRepository {
	// C
	String createTrainer(String Trainer);

	// R
	String getAllTrainers();

	String getATrainer(Long id);

	// U
	String updateTrainer(String Trainer, Long id);

	// D
	String deleteTrainer(Long id);
}
