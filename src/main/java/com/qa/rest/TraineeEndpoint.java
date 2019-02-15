package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.buisness.service.TraineeService;

@Path("/Trainee")
public class TraineeEndpoint {

	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();

	}

	@Path("/getATrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getATrainee(@PathParam("id") Long id) {
		return service.getATrainee(id);
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String Trainee) {
		return service.addTrainee(Trainee);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteTrainee(id);
	}

	public void setService(TraineeService service) {
		this.service = service;
	}

}
