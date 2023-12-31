package com.example.firstservice.util.filters;

import com.example.firstservice.entity.Organization;
import com.example.firstservice.entity.OrganizationType;
import com.example.firstservice.exception.IncorrectOrganizationFilterException;
import com.example.commonservice.enums.SortingOrFilteringField;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrganizationFilterService {

    public static List<OrganizationFilter> parseFilters(@NotNull List<String> filters) {
        return filters.stream()
                .map(OrganizationFilterService::parseFilter)
                .collect(Collectors.toList());
    }

    public static OrganizationFilter parseFilter(String filter) {
        String[] parts = filter.split("<=|>=|!=|==|<|>"); // TODO it's bad for orgs with filter like 'name==babani<30rublei'
        if (parts.length == 2) {
            OrganizationFilter result = new OrganizationFilter();
            result.setField(parts[0]);
            result.setOperator(filter.substring(parts[0].length(), filter.length() - parts[1].length()));
            result.setValue(parts[1]);

            // for logs
            System.out.println("Filter was -> " + filter + ", parts -> " + parts[0] + " " + result.getOperator() + " " + parts[1]);
            // TODO check for correct filter fillings
            //  for example that the operator is '<' or '>=' ...

            return result;
        }

        throw new IncorrectOrganizationFilterException(filter);
    }

    public static boolean applyFilters(Organization organization, List<OrganizationFilter> filters) {
        for (OrganizationFilter filter : filters) {
            SortingOrFilteringField field = SortingOrFilteringField.fromValue(filter.getField());
            String operator = filter.getOperator();
            String value = filter.getValue();

            switch (Objects.requireNonNull(field)) {
                case ID:
                    long id = organization.getId();
                    if (!compare(id, operator, Long.parseLong(value))) {
                        return false;
                    }
                    break;
                case NAME:
                    String name = organization.getName();
                    if (!compare(name, operator, value)) {
                        return false;
                    }
                    break;
                case ANNUALTURNOVER:
                    Double annualTurnover = organization.getAnnualTurnover();
                    if (!compare(annualTurnover, operator, Double.parseDouble(value))) {
                        return false;
                    }
                    break;
                case OFFICIALADDRESS_ZIPCODE:
                    String zipcode = organization.getAddress().getZipCode();
                    if (!compare(zipcode, operator, value)) {
                        return false;
                    }
                    break;
                case OFFICIALADDRESS_STREET:
                    String street = organization.getAddress().getStreet();
                    if (!compare(street, operator, value)) {
                        return false;
                    }
                    break;
                case CREATIONDATE:
                    long creationDate = organization.getCreationDate().getTime();
                    if (!compare(creationDate, operator, Date.parse(value))) {
                        return false;
                    }
                    break;
                case TYPE:
                    OrganizationType type = organization.getOrganizationType();
                    if (!compare(type.getType(), operator, value.toUpperCase())) {
                        return false;
                    }
                    break;
                case COORDINATES_X:
                    double x = organization.getCoordinates().getX();
                    if (!compare(x, operator, Double.parseDouble(value))) {
                        return false;
                    }
                    break;
                case COORDINATES_Y:
                    long y = organization.getCoordinates().getY();
                    if (!compare(y, operator, Long.parseLong(value))) {
                        return false;
                    }
                    break;
                case EMPLOYEES_COUNT:
                    int y1 = organization.getEmployees().size();
                    if (!compare(y1, operator, Integer.parseInt(value))) {
                        return false;
                    }
                    break;
                default:
                    // TODO think about this case maybe throw here exception
            }

        }

        return true;
    }

    private static <T extends Comparable<T>> boolean compare(T left, String operator, T right) {
        int comparison = left.compareTo(right);

        switch (operator) {
            case "<":
                return comparison < 0;
            case "<=":
                return comparison <= 0;
            case ">":
                return comparison > 0;
            case ">=":
                return comparison >= 0;
            case "==":
                return comparison == 0;
            case "!=":
                return comparison != 0;
            default:
                return false; // Недопустимый оператор
        }

    }

    private static boolean compare(String left, String operator, String right) {
        switch (operator) {
            case "==":
                return left.equals(right);
            case "!=":
                return !left.equals(right);
            default:
                return false; // Недопустимый оператор
        }
    }
}
