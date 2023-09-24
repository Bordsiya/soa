package com.example.firstservice.repository;

import com.example.firstservice.entity.Organization;
import com.example.firstservice.models.AnnualTurnoverOrganizationsCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findOrganizationByAddress_Id(Integer addressId);

    @Query(value = "select sum(annual_turnover) from organization", nativeQuery = true)
    Double getSumOfOrganizationsAnnualTurnovers();

    @Query("SELECT " +
            "    new com.example.firstservice.models.AnnualTurnoverOrganizationsCountDTO(o.annualTurnover, COUNT(o)) " +
            "FROM " +
            "    Organization o " +
            "GROUP BY " +
            "    o.annualTurnover")
    List<AnnualTurnoverOrganizationsCountDTO> getGroupedOrganizationsByAnnualTurnover();
}
