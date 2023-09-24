package com.example.firstservice.exception.not_found;

public class CoordinatesNotFoundException extends ResourceNotFoundException {
    public CoordinatesNotFoundException(Integer coordinatesId) {
        super("Coordinates", "coordinates-id", coordinatesId.toString());
    }

    public CoordinatesNotFoundException(Double x, Long y) {
        super("Coordinates", "coordinates-x, coordinates-y", x.toString() + ", " + y.toString());
    }
}