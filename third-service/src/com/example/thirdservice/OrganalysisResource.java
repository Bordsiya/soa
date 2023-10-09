package com.example.thirdservice;

import lombok.extern.slf4j.Slf4j;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/organalysis")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganalysisResource {

	private final RestClientService restClientService = new RestClientService();

	@GET
	@Path("predict/organizations/{id}/annual-turnover")
	public Response predictOrganizationAnnualTurnoverBehavior(@PathParam("id") Integer id) {
		return Response.ok(restClientService.predictOrganizationAnnualTurnoverBehavior(id), MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("recommend/coordinates/quarter")
	public Response recommendCoordinateQuarter() {
		return Response.ok(restClientService.recommendCoordinateQuarter(), MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("recommend/organizations/coordinates")
	public Response recommendOrganizationsByCoordinates(
			@QueryParam("x") Double x,
			@QueryParam("y") Long y
	) {
		return Response.ok(restClientService.recommendOrganizationsByCoordinates(x, y)).build();
	}
}
