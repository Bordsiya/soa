package com.example.firstservice.util.comparators;

import com.example.firstservice.entity.Organization;
import com.example.firstservice.util.enums.SortingOrFilteringField;

import java.util.Comparator;

public class OrganizationComparator {
    public static Comparator<Organization> compareById() {
        return Comparator.comparing(Organization::getId);
    }

    public static Comparator<Organization> compareByName() {
        return Comparator.comparing(Organization::getName);
    }

    public static Comparator<Organization> compareByAnnualTurnover() {
        return Comparator.comparingDouble(Organization::getAnnualTurnover);
    }

    public static Comparator<Organization> compareByCoordinatesX() {
        return Comparator.comparingDouble(org -> org.getCoordinates().getX());
    }

    public static Comparator<Organization> compareByCoordinatesY() {
        return Comparator.comparingLong(org -> org.getCoordinates().getY());
    }

    public static Comparator<Organization> compareByType() {
        return Comparator.comparing(org -> org.getOrganizationType().getType());
    }

    public static Comparator<Organization> compareByCreationDate() {
        return Comparator.comparingLong(org -> org.getCreationDate().getTime());
    }

    public static Comparator<Organization> compareByOfficialAddressStreet() {
        return Comparator.comparing(org -> org.getAddress().getStreet());
    }

    public static Comparator<Organization> compareByOfficialAddressZipCode() {
        return Comparator.comparing(org -> org.getAddress().getZipCode());
    }

    public static Comparator<Organization> findComparatorByFieldName(SortingOrFilteringField field) {
        switch (field) {
            case ID -> {
                return compareById();
            }
            case NAME -> {
                return compareByName();
            }
            case ANNUALTURNOVER -> {
                return compareByAnnualTurnover();
            }
            case COORDINATES_X -> {
                return compareByCoordinatesX();
            }
            case COORDINATES_Y -> {
                return compareByCoordinatesY();
            }
            case TYPE -> {
                return compareByType();
            }
            case CREATIONDATE -> {
                return compareByCreationDate();
            }
            case OFFICIALADDRESS_STREET -> {
                return compareByOfficialAddressStreet();
            }
            case OFFICIALADDRESS_ZIPCODE -> {
                return compareByOfficialAddressZipCode();
            }
        }
        return Comparator.comparing(obj -> 0);
    }
}
