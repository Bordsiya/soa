package com.example.firstservice.util.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of Organization
 */
public enum OrganizationTypeDto {
    COMMERCIAL("COMMERCIAL"),
    PUBLIC("PUBLIC"),
    OPEN_JOINT_STOCK_COMPANY("OPEN_JOINT_STOCK_COMPANY");

    private String value;

    OrganizationTypeDto(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static OrganizationTypeDto fromValue(String text) {
        for (OrganizationTypeDto b : OrganizationTypeDto.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
