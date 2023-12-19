package org.example.models.enums;

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
        this.value = value.toUpperCase();
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static OrganizationTypeDto fromValue(String text) {
        for (OrganizationTypeDto b : OrganizationTypeDto.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
