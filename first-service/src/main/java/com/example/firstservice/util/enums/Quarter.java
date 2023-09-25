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
}
