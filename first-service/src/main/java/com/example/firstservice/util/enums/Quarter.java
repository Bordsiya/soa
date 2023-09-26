package com.example.firstservice.util.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Quarter
 */
public enum Quarter {
  I("I"),
  II("II"),
  III("III"),
  IV("IV");

  private String value;

  Quarter(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Quarter fromValue(String text) {
    for (Quarter b : Quarter.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static Quarter fromCoordinates(Double x, Long y) {
    if (x > 0 && y > 0) return Quarter.I;
    else if (x < 0 && y > 0) return Quarter.II;
    else if (x < 0 && y < 0) return Quarter.III;
    else return Quarter.IV;
  }

  public static int toNumber(Quarter quarter) {
    if (quarter == Quarter.I) return 0;
    else if (quarter == Quarter.II) return 1;
    else if (quarter == Quarter.III) return 2;
    else return 3;
  }
}
