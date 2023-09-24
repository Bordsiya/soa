package com.example.thirdservice.controller;

import com.example.firstservice.models.CoordinatesDTO;
import com.example.firstservice.util.enums.OrganizationTypeType;
import com.example.thirdservice.api.OrganalysisApi;
import com.example.thirdservice.exception.NullArgsInRequestException;
import com.example.thirdservice.models.QuarterResponseDTO;
import com.example.thirdservice.models.PredictionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrganalysisController implements OrganalysisApi {

    @Override
    public ResponseEntity<List<PredictionDTO>> predictOrganizationAnnualTurnoverBehavior(Integer id) {
        if (id == null) throw new NullArgsInRequestException("id");

        return null;
    }

    @Override
    public ResponseEntity<QuarterResponseDTO> recommendCoordinateQuarter() {
        return null;
    }

    @Override
    public ResponseEntity<List<Object>> recommendOrganizationsByCoordinates(CoordinatesDTO coordinatesDTO, Long amount, OrganizationTypeType organizationTypeType) {
        if (coordinatesDTO == null) throw new NullArgsInRequestException("id");
        if (amount == null) throw new NullArgsInRequestException("amount");
        if (organizationTypeType == null) throw new NullArgsInRequestException("organizationType");


        return null;
    }
}
