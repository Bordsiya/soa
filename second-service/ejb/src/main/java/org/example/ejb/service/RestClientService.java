package org.example.ejb.service;

import org.example.ejb.model.OrganizationDTO;

import javax.ejb.Remote;
import java.util.List;

public interface RestClientService {
    List<OrganizationDTO> getOrganizationsFilteredByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover);
    List<OrganizationDTO> getOrganizationsFilteredByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount);
}
