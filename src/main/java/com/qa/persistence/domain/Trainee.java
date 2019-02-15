package com.qa.persistence.domain;

public class Trainee 
{
	private long traineeId = 1l;
	private String traineeName = "";
	
	
	
	
	
	
	
	public long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public Trainee(long traineeId, String traineeName) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
	}
	public Trainee() {
	}	
}
