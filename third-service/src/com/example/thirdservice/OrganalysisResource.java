package com.example.thirdservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;


@Path("/organalysis")
public class OrganalysisResource {
	/*
	private final RestClientService restClientService = new RestClientService();

*/

	@GET
	@Path("predict/organizations/{id}/annual-turnover")
	@Produces(MediaType.APPLICATION_JSON)
	public String predictOrganizationAnnualTurnoverBehavior(@PathParam("id") Integer id) {
		return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde1!\"}";
	}

	@GET
	@Path("recommend/coordinates/quarter")
	//@Produces(MediaType.APPLICATION_JSON)
	public String recommendCoordinateQuarter() {
		return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde2!\"}";
	}

	@GET
	@Path("recommend/organizations/coordinates")
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public String recommendOrganizationsByCoordinates() {
		return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde3!\"}";
	}
}
