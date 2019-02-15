package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomid = 1l;
	private String trainerName = "";

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Trainee> trainees = new ArrayList<>();

	public void addtrainee(Trainee trainee) {
		trainees.add(trainee);
	}

	public void removetrainee(Trainee trainee) {
		trainees.remove(trainee);
	}

	// Constructors, getters and setters removed for brevity

	public Trainer() {

	}

	public Trainer(Long classroomid, String trainerName) {
		super();
		this.classroomid = classroomid;
		this.trainerName = trainerName;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

}
