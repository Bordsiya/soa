/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.firstservice.api;

import com.example.commonservice.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-22T14:28:41.491075200+03:00[Europe/Moscow]")
@Validated
public interface OrganizationsApi {

    @Operation(tags={ "basic set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns added Organization", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))})
    @RequestMapping(value = "/organizations",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<OrganizationDTO> addOrganization(
            @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema())
            @Valid @RequestBody OrganizationWithoutIdDTO body);


    @Operation(tags={ "basic set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content"),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))})
    @RequestMapping(value = "/organizations/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteOrganizationById(
            @Parameter(in = ParameterIn.PATH, description = "Organization ID to delete", required=true,
                    schema=@Schema(minimum="1")) @PathVariable("id") Integer id);


    @Operation(tags={ "advanced set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "No Content"),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))})
    @RequestMapping(value = "/organizations/official-address",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteOrganizationByOfficialAddress(
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "Official address street for Organization deletion", required=true,
                    schema=@Schema(minLength = 1, example = "Kosovo street", required = true, description = "Address street"))
            @Valid @RequestParam(value = "officialAddressStreet", required = true)
            String officialAddressStreet,
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "Official address zipcode for Organization deletion", required=true,
                    schema=@Schema(minLength = 1, example = "AE84C", required = true, description = "Address zipcode"))
            @Valid @RequestParam(value = "officialAddressZipCode", required = true)
            String officialAddressZipCode
    );


    @Operation(tags={ "advanced set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns grouped Organizations by annual turnover", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AnnualTurnoverOrganizationsCountDTO.class)))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))})
    @RequestMapping(value = "/organizations/annual-turnover/grouped",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<AnnualTurnoverOrganizationsCountDTO>> getGroupedOrganizationsByAnnualTurnover();


    @Operation(tags={ "basic set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns Organization by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))})
    @RequestMapping(value = "/organizations/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<OrganizationDTO> getOrganizationById(
            @Parameter(in = ParameterIn.PATH, description = "Organization ID to get", required=true,
                    schema=@Schema(minimum="1")) @PathVariable("id") Integer id);


    @Operation(summary = "Get Organizations with preferences", description = "sorting and filtration fields: id, name, coordinates(x and y), creationDate, annualTurnover, type, officialAddress(street and zipCode)", tags={ "basic set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns Organization by ID", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizationDTO.class)))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class)))})
    @RequestMapping(value = "/organizations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<OrganizationDTO>> getOrganizationsWithPreferences(
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,
                    schema=@Schema( defaultValue="1")) @Valid @RequestParam(value = "pageNumber", required = true,
                    defaultValue="1") Integer pageNumber,
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,
                    schema=@Schema( defaultValue="5")) @Valid @RequestParam(value = "pageSize", required = true,
                    defaultValue="5") Integer pageSize,
            @Parameter(in = ParameterIn.QUERY,
                    description = "Поле, по которому нужно сортировать (enum с множественным выбором).",
                    schema=@Schema(allowableValues={ "id", "name", "coordinates.x", "coordinates.y", "creationDate",
                            "annualTurnover", "type", "officialAddress.street", "officialAddress.zipCode" }))
            @Valid @RequestParam(value = "sortBy", required = false) List<String> sortBy,
            @Valid @RequestParam(value = "filters", required = false) List<String> filters
    );


    @Operation(summary = "Get sum of all Organizations annual turnovers", tags={ "advanced set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns sum of all Organizations annual turnovers", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OnlyAnnualTurnoverDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),})
    @RequestMapping(value = "/organizations/annual-turnover/sum",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<OnlyAnnualTurnoverDTO> getSumOfOrganizationsAnnualTurnovers();


    @Operation(tags={ "basic set" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns updated Organization", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "The request was bad composed", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),})
    @RequestMapping(value = "/organizations/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<OrganizationDTO> updateOrganizationById(
            @Parameter(in = ParameterIn.PATH, description = "Organization ID to update",
                    required=true, schema=@Schema(minimum="1"))
            @PathVariable("id") Integer id, @Parameter(in = ParameterIn.DEFAULT, description = "",
            required=true, schema=@Schema()) @Valid @RequestBody OrganizationWithoutIdDTO body);

}

