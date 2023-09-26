package com.example.firstservice.repository;

import com.example.firstservice.entity.Organization;
import com.example.firstservice.models.AnnualTurnoverOrganizationsCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findOrganizationByAddress_Id(Integer addressId);

    @Query(value = "select sum(annual_turnover) from soa.organization", nativeQuery = true)
    Double getSumOfOrganizationsAnnualTurnovers();

    @Query("SELECT " +
            "    new com.example.firstservice.models.AnnualTurnoverOrganizationsCountDTO(o.annualTurnover, COUNT(o)) " +
            "FROM " +
            "    Organization o " +
            "GROUP BY " +
            "    o.annualTurnover")
    List<AnnualTurnoverOrganizationsCountDTO> getGroupedOrganizationsByAnnualTurnover();

    @Query(value = "select grouped_organizations.id from (select soa.organization.id, count(*) from soa.organization " +
            "    inner join soa.organization_type ot on soa.organization.type_id = ot.id " +
            "       inner join soa.coordinates c on soa.organization.coordinates_id = c.id " +
            "       inner join soa.employee e on soa.organization.id = e.organization_id " +
            "    where soa.organization.annual_turnover > :annualTurnover" +
            "    and sqrt(power(:x - c.x, 2)) + sqrt(power(:y - c.y, 2)) < 1000 " +
            "    and soa.organization.id != :id" +
            "        group by soa.organization.id having count(*) > :employeesCount) as grouped_organizations", nativeQuery = true)
    List<Integer> findCompetitiveOrganizationsIds(
            @Param("id") Integer id,
            @Param("x") Double x,
            @Param("y") Long y,
            @Param("annualTurnover") Double annualTurnover,
            @Param("employeesCount") int employeesCount
    );

}
