package com.example.firstservice.repository;

import com.example.firstservice.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
    Coordinates findCoordinatesByXAndY(Double x, Long y);
}
