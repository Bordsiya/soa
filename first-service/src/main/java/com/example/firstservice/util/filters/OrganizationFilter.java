package com.example.firstservice.util.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationFilter {
    private String field;
    private String operator;
    private String value;
}
