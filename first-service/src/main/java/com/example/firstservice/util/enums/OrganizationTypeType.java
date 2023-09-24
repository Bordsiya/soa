package com.example.firstservice.util.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of Organization
 */
public enum OrganizationTypeType {
    COMMERCIAL("COMMERCIAL"),
    PUBLIC("PUBLIC"),
    OPEN_JOINT_STOCK_COMPANY("OPEN_JOINT_STOCK_COMPANY");

  private String value;

  OrganizationTypeType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OrganizationTypeType fromValue(String text) {
    for (OrganizationTypeType b : OrganizationTypeType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
