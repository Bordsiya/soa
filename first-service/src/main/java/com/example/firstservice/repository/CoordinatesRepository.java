package com.example.firstservice.repository;

import com.example.firstservice.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
    Coordinates findCoordinatesByXAndY(Double x, Long y);
    @Query(value = "select count(c.id) from soa.coordinates c where c.x > 0 and c.y > 0", nativeQuery = true)
    Long countCoordinatesFirstQuarter();
    @Query(value = "select count(c.id) from soa.coordinates c where c.x < 0 and c.y > 0", nativeQuery = true)
    Long countCoordinatesSecondQuarter();
    @Query(value = "select count(c.id) from soa.coordinates c where c.x < 0 and c.y < 0", nativeQuery = true)
    Long countCoordinatesThirdQuarter();
    @Query(value = "select count(c.id) from soa.coordinates c where c.x > 0 and c.y < 0", nativeQuery = true)
    Long countCoordinatesFourthQuarter();
}
