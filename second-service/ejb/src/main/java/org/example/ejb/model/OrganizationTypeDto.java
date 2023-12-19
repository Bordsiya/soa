package org.example.ejb.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Type of Organization
 */
public enum OrganizationTypeDto implements Serializable {
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
