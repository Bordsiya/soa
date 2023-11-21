package com.example.backend.controller;

import com.example.backend.api.OrgdirectoryApi;
import org.example.ejb.service.RestClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class OrgdirectoryController implements OrgdirectoryApi {

    private RestClientService restClientService;

    @Override
    public ResponseEntity<?> filterOrganizationsByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover) {
        return ResponseEntity.ok(restClientService.getOrganizationsFilteredByAnnualTurnover(minAnnualTurnover, maxAnnualTurnover));
    }

    @Override
    public ResponseEntity<?> filterOrganizationsByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        return ResponseEntity.ok(restClientService.getOrganizationsFilteredByEmployeesCount(minEmployeesCount, maxEmployeesCount));
    }
}
