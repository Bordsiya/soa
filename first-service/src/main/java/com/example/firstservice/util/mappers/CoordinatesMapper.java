package com.example.firstservice.util.mappers;

import com.example.firstservice.entity.Coordinates;
import com.example.firstservice.entity.Organization;
import com.example.firstservice.models.CoordinatesDTO;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesMapper {
    public Coordinates fromDTO(CoordinatesDTO coordinatesDTO, Organization organization) {
        return new Coordinates(
                0,
                coordinatesDTO.getX(),
                coordinatesDTO.getY(),
                organization
        );
    }
}
