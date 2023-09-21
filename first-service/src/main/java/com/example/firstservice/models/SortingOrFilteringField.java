package com.example.firstservice.models;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Type of filtration
 */
public enum SortingOrFilteringField {
  ID("id"),
    NAME("name"),
    COORDINATES_X("coordinates.x"),
    COORDINATES_Y("coordinates.y"),
    CREATIONDATE("creationDate"),
    ANNUALTURNOVER("annualTurnover"),
    TYPE("type"),
    OFFICIALADDRESS_STREET("officialAddress.street"),
    OFFICIALADDRESS_ZIPCODE("officialAddress.zipcode");

  private String value;

  SortingOrFilteringField(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SortingOrFilteringField fromValue(String text) {
    for (SortingOrFilteringField b : SortingOrFilteringField.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
