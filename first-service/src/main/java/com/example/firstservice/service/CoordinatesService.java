package com.example.firstservice.service;

import com.example.firstservice.entity.Coordinates;
import com.example.firstservice.exception.not_found.CoordinatesNotFoundException;
import com.example.commonservice.model.CoordinatesDTO;
import com.example.commonservice.model.QuarterResponseDTO;
import com.example.firstservice.repository.CoordinatesRepository;
import com.example.commonservice.enums.Quarter;
import com.example.firstservice.util.mappers.QuarterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    public List<Long> getAmountOfOrganizationsForEachCoordinateQuarter() {
        Long firstQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesFirstQuarter();
        Long secondQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesSecondQuarter();
        Long thirdQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesThirdQuarter();
        Long fourthQuarterOrganizationsAmount = coordinatesRepository.countCoordinatesFourthQuarter();
        List<Long> myList = new ArrayList<>();
        myList.add(firstQuarterOrganizationsAmount);
        myList.add(secondQuarterOrganizationsAmount);
        myList.add(thirdQuarterOrganizationsAmount);
        myList.add(fourthQuarterOrganizationsAmount);
        return myList;
    }

    private Quarter findTheEmptiestCoordinateQuarter() {
        List<Long> amountOfOrganizationsForEachCoordinateQuarter = getAmountOfOrganizationsForEachCoordinateQuarter();
        int minInd = IntStream.range(0, amountOfOrganizationsForEachCoordinateQuarter.size())
                .reduce((i,j) -> amountOfOrganizationsForEachCoordinateQuarter.get(i)
                        > amountOfOrganizationsForEachCoordinateQuarter.get(j) ? j : i)
                .getAsInt();
        if (minInd == 0) return Quarter.I;
        else if (minInd == 1) return Quarter.II;
        else if (minInd == 2) return Quarter.III;
        else return Quarter.IV;
    }

    public QuarterResponseDTO recommendQuarter() {
        return quarterMapper.toDTO(findTheEmptiestCoordinateQuarter());
    }
}
