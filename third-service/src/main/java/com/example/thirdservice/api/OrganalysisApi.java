/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.thirdservice.api;

import com.example.firstservice.models.ErrorDTO;
import com.example.firstservice.models.CoordinatesDTO;
import com.example.firstservice.util.enums.OrganizationTypeType;
import com.example.thirdservice.models.QuarterResponseDTO;
import com.example.thirdservice.models.PredictionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T22:04:54.480604900+03:00[Europe/Moscow]")
@Validated
@Path("/organalysis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrganalysisApi {

    @Operation(summary = "Predict organization annual turnover behavior",
            description = "Get prediction of Organization annual turnover behavior", tags={ "prediction" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns Annual Turnover prediction",
                content = @Content(mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = PredictionDTO.class)))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500",
                description = "Internal Server error",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDTO.class)))})
    @GET
    @Path("/predict/organizations/{id}/annual-turnover")
    ResponseEntity<List<PredictionDTO>> predictOrganizationAnnualTurnoverBehavior(
            @Min(1) @Parameter(in = ParameterIn.PATH, description = "Organization id",
                    required=true, schema=@Schema(allowableValues={ "1" }, minimum="1"))
            @PathParam("id")
            Integer id);


    @Operation(summary = "Recommend coordinate quarter for organization",
            description = "Get recommended coordinate quarter", tags={ "recommendation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns recommended coordination quarter",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = QuarterResponseDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDTO.class)))})
    @GET
    @Path("/recommend/coordinates/quarter")
    ResponseEntity<QuarterResponseDTO> recommendCoordinateQuarter();


    @Operation(summary = "Recommend organizations by coordinates",
            description = "Get recommended organizations (customized amount) by coordinates and with/without Organization Type filter",
            tags={ "recommendation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns recommended Organizations",
                content = @Content(mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Object.class)))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorDTO.class)))})
    @GET
    @Path("/recommend/organizations/coordinates")
    ResponseEntity<List<Object>> recommendOrganizationsByCoordinates(
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "Start coordinates",
                    required=true, schema=@Schema())
            @Valid @QueryParam(value = "coordinates")
            CoordinatesDTO coordinatesDTO,
            @Min(1L) @Parameter(in = ParameterIn.QUERY, description = "Amount of requested recommended Organizations",
                    schema=@Schema(allowableValues={ "1" }, minimum="1", defaultValue="5"))
            @Valid @QueryParam(value = "amount") @DefaultValue("5")
            Long amount,
            @Parameter(in = ParameterIn.QUERY, description = "Organization type" ,schema=@Schema())
            @Valid @QueryParam(value = "organizationType")
            OrganizationTypeType organizationTypeType);

}

