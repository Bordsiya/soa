package com.example.secondservice.controller;

import com.example.commonservice.model.OrganizationDTO;
import com.example.secondservice.api.OrgdirectoryApi;
import com.example.secondservice.rest_client.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrgdirectoryController implements OrgdirectoryApi {
    private final RestClientService restClientService;

    @Autowired
    public OrgdirectoryController(
            RestClientService restClientService
    ) {
        this.restClientService = restClientService;
    }

    @Override
    public ResponseEntity<List<OrganizationDTO>> filterOrganizationsByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover) {
        return ResponseEntity.ok(restClientService.getOrganizationsFilteredByAnnualTurnover(minAnnualTurnover, maxAnnualTurnover));
    }

    @Override
    public ResponseEntity<List<OrganizationDTO>> filterOrganizationsByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        return ResponseEntity.ok(restClientService.getOrganizationsFilteredByEmployeesCount(minEmployeesCount, maxEmployeesCount));
    }
}
