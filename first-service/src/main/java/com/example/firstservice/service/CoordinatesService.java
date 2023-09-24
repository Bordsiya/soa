package com.example.firstservice.service;

import com.example.firstservice.entity.Coordinates;
import com.example.firstservice.exception.not_found.CoordinatesNotFoundException;
import com.example.firstservice.models.CoordinatesDTO;
import com.example.firstservice.repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesService {
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    public CoordinatesService(
            CoordinatesRepository coordinatesRepository
    ) {
        this.coordinatesRepository = coordinatesRepository;
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

}
