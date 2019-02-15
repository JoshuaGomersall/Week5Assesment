package com.qa.persistence.domain;

public class Trainer 
{
	private Long classroomid = 1l; 
	private String trainerName = "";
	
	
	
	public Trainer()
	{
		
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
