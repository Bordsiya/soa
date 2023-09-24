package com.example.secondservice.controller;

import com.example.firstservice.models.OrganizationDTO;
import com.example.secondservice.api.OrgdirectoryApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrgdirectoryController implements OrgdirectoryApi {
    @Override
    public ResponseEntity<List<OrganizationDTO>> filterOrganizationsByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover) {
        return null;
    }

    @Override
    public ResponseEntity<List<Object>> filterOrganizationsByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        return null;
    }
}
