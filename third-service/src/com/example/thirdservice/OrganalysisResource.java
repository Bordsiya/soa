package com.example.thirdservice;

import com.example.commonservice.model.OrganizationDTO;
import com.example.commonservice.model.PredictionDTO;
import com.example.commonservice.model.QuarterResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/organalysis")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganalysisResource {

	private final RestClientService restClientService = new RestClientService();

	@GET
	@Path("predict/organizations/{id}/annual-turnover")
	public ResponseEntity<PredictionDTO> predictOrganizationAnnualTurnoverBehavior(@PathParam("id") Integer id) {
		return ResponseEntity.ok(restClientService.predictOrganizationAnnualTurnoverBehavior(id));
	}

	@GET
	@Path("recommend/coordinates/quarter")
	public ResponseEntity<QuarterResponseDTO> recommendCoordinateQuarter() {
		return ResponseEntity.ok(restClientService.recommendCoordinateQuarter());
	}

	@GET
	@Path("recommend/organizations/coordinates")
	public ResponseEntity<List<OrganizationDTO>> recommendOrganizationsByCoordinates(
			@QueryParam("x") Double x,
			@QueryParam("y") Long y
	) {
		return ResponseEntity.ok(restClientService.recommendOrganizationsByCoordinates(x, y));
	}
}
