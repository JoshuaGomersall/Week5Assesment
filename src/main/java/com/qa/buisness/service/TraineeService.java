package com.qa.buisness.service;

public interface TraineeService {
	// C
	String addTrainee(String Trainee);

	// R
	String getAllTrainees();

	String getATrainee(Long id);

	// U
	String updateTrainee(String Trainee, Long id);

	// D
	String deleteTrainee(Long id);
}
