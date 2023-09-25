package com.example.firstservice.service;

import com.example.firstservice.entity.Coordinates;
import com.example.firstservice.exception.not_found.CoordinatesNotFoundException;
import com.example.firstservice.models.CoordinatesDTO;
import com.example.firstservice.models.QuarterResponseDTO;
import com.example.firstservice.repository.CoordinatesRepository;
import com.example.firstservice.util.enums.Quarter;
import com.example.firstservice.util.mappers.QuarterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CoordinatesService {
    private CoordinatesRepository coordinatesRepository;
    private QuarterMapper quarterMapper;

    @Autowired
    public CoordinatesService(
            CoordinatesRepository coordinatesRepository,
            QuarterMapper quarterMapper
    ) {
        this.coordinatesRepository = coordinatesRepository;
        this.quarterMapper = quarterMapper;
    }

    public Coordinates getCoordinatesById(Integer coordinatesId) {
        return coordinatesRepository.findById(coordinatesId)
                .orElseThrow(() -> new CoordinatesNotFoundException(coordinatesId));
    }

    public Coordinates findCoordinatesByXAndY(Double x, Long y){
        Coordinates coordinates = coordinatesRepository.findCoordinatesByXAndY(x, y);
        if (coordinates == null) throw new CoordinatesNotFoundException(x, y);
        return coordinates;
    }

    public Coordinates updateCoordinates(Integer id, CoordinatesDTO coordinatesDTO) {
        Coordinates coordinates = getCoordinatesById(id);
        coordinates.setX(coordinatesDTO.getX());
        coordinates.setY(coordinatesDTO.getY());
        return coordinatesRepository.save(coordinates);
    }

    private Quarter findTheEmptiestCoordinateQuarter() {
        Long firstQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesFirstQuarter();
        Long secondQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesSecondQuarter();
        Long thirdQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesThirdQuarter();
        Long fourthQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesFourthQuarter();

        Long minOrganizationsAmount = Collections.min(List.of(
                firstQuarterOrganizationsAmount,
                secondQuarterOrganizationsAmount,
                thirdQuarterOrganizationsAmount,
                fourthQuarterOrganizationsAmount
        ));
        if (firstQuarterOrganizationsAmount.equals(minOrganizationsAmount)) return Quarter.I;
        else if (secondQuarterOrganizationsAmount.equals(minOrganizationsAmount)) return Quarter.II;
        else if (thirdQuarterOrganizationsAmount.equals(minOrganizationsAmount)) return Quarter.III;
        else return Quarter.IV;
    }

    public QuarterResponseDTO recommendQuarter() {
        return quarterMapper.toDTO(findTheEmptiestCoordinateQuarter());
    }
}
