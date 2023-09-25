package com.example.firstservice.controller;

import com.example.firstservice.api.OrganizationsApi;
import com.example.firstservice.exception.PageableConditionsException;
import com.example.firstservice.models.*;
import com.example.firstservice.service.OrganizationService;
import com.example.firstservice.util.mappers.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrganizationController implements OrganizationsApi {
    private OrganizationService organizationService;
    private OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationController(
            OrganizationService organizationService,
            OrganizationMapper organizationMapper
    ) {
        this.organizationService = organizationService;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public ResponseEntity<OrganizationDTO> addOrganization(OrganizationWithoutIdDTO body) {
        return ResponseEntity.ok(
                organizationMapper.toDTO(organizationService.addOrganization(body))
        );
    }

    @Override
    public ResponseEntity<Void> deleteOrganizationById(Integer id) {
        organizationService.deleteOrganizationById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteOrganizationByOfficialAddress(String officialAddressStreet,
                                                                    String officialAddressZipcode) {
        AddressDTO addressDTO = new AddressDTO(officialAddressStreet, officialAddressZipcode);
        organizationService.deleteOrganizationByOfficialAddress(addressDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<AnnualTurnoverOrganizationsCountDTO>> getGroupedOrganizationsByAnnualTurnover() {
        return ResponseEntity.ok(organizationService.getGroupedOrganizationsByAnnualTurnover());
    }

    @Override
    public ResponseEntity<OrganizationDTO> getOrganizationById(Integer id) {
        return ResponseEntity.ok(
                organizationMapper.toDTO(organizationService.getOrganizationById(id))
        );
    }

    @Override
    public ResponseEntity<List<OrganizationDTO>> getOrganizationsWithPreferences(
            Integer pageNumber,
            Integer pageSize,
            List<String> sortBy, List<String> filters
    ) {
        List<OrganizationDTO> orgsWithPrefs = organizationMapper
                .toDTO(organizationService.getOrganizationsWithPreferences(sortBy, filters));

        if (pageNumber == 0 || pageSize == 0) {
            return ResponseEntity.ok(orgsWithPrefs);
        }
        int start = (pageNumber - 1) * pageSize;
        int end = Math.min(start + pageSize, orgsWithPrefs.size());
        if (start >= orgsWithPrefs.size() || start < 0 || end < 0 || end > orgsWithPrefs.size()) {
            throw new PageableConditionsException();
        }
        return ResponseEntity.ok(
                orgsWithPrefs.subList(start, end)
        );
    }

    @Override
    public ResponseEntity<OnlyAnnualTurnoverDTO> getSumOfOrganizationsAnnualTurnovers() {
        return ResponseEntity.ok(organizationService.getSumOfOrganizationsAnnualTurnovers());
    }

    @Override
    public ResponseEntity<OrganizationDTO> updateOrganizationById(Integer id, OrganizationWithoutIdDTO body) {
        return ResponseEntity.ok(
                organizationMapper.toDTO(organizationService.updateOrganizationById(id, body))
        );
    }
}
