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
	private Long classroomId = 1l;
	private String trainerName = "";

	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Trainee> trainees = new ArrayList<>();

	
	
	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

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
		this.classroomId = classroomid;
		this.trainerName = trainerName;
	}

	public Long getClassroomid() {
		return classroomId;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomId = classroomid;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

}
