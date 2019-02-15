package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trainee 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long traineeId = 1l;
	private String traineeName = "";

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "classroomId")
	
	
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
