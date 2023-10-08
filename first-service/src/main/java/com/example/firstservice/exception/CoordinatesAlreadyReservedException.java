package com.example.firstservice.exception;

public class CoordinatesAlreadyReservedException extends RuntimeException {
    public CoordinatesAlreadyReservedException(Double x, Long y) {
        super("Coordinates [" + x.toString() + "; " + y.toString() + "] already reserved");
    }
}
