package com.qa.persistence.repository;

public interface TraineeRepository {
	// C
	String createTrainee(String Trainee);

	// R
	String getAllTrainees();

	String getATrainee(Long id);

	// U
	String updateTrainee(String Trainee, Long id);

	// D
	String deleteTrainee(Long id);

	//int cycleTrainees(String title);
}
