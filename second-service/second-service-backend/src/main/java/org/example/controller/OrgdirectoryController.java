package org.example.controller;

import org.example.api.OrgdirectoryApi;
import org.example.models.model.OrganizationDTO;
import org.example.util.JndiUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.example.ejb.service.RestClientService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrgdirectoryController implements OrgdirectoryApi {

    @Override
    public ResponseEntity<?> filterOrganizationsByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover) {
        return ResponseEntity.ok(getService().getOrganizationsFilteredByAnnualTurnover(minAnnualTurnover, maxAnnualTurnover));
    }

    @Override
    public ResponseEntity<?> filterOrganizationsByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        return ResponseEntity.ok(getService().getOrganizationsFilteredByEmployeesCount(minEmployeesCount, maxEmployeesCount));
    }

    private RestClientService getService() {
        return JndiUtils.getFromContext(RestClientService.class, getFullName());
    }

    @SuppressWarnings("rawtypes")
    private String getFullName() {
        return "ejb:/ejb-1.0-SNAPSHOT/RestClientServiceBean!org.example.ejb.service.RestClientService";
    }
}
