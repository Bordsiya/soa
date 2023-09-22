package com.example.firstservice.controller;

import com.example.firstservice.api.OrganizationsApi;
import com.example.firstservice.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationController implements OrganizationsApi {
    @Override
    public ResponseEntity<Organization> addOrganization(OrganizationWithoutId body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteOrganizationById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteOrganizationByOfficialAddress(Address officialAddress) {
        return null;
    }

    @Override
    public ResponseEntity<List<AnnualTurnoverOrganizationsCount>> getGroupedOrganizationsByAnnualTurnover() {
        return null;
    }

    @Override
    public ResponseEntity<Organization> getOrganizationById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Organization>> getOrganizationsWithPreferences(Integer pageNumber, Integer pageSize, List<String> sortBy) {
        return null;
    }

    @Override
    public ResponseEntity<OnlyAnnualTurnover> getSumOfOrganizationsAnnualTurnovers() {
        return null;
    }

    @Override
    public ResponseEntity<Organization> updateOrganizationById(Integer id, OrganizationWithoutId body) {
        return null;
    }
}
