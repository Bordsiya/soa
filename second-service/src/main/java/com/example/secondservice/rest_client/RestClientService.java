package com.example.secondservice.rest_client;

import com.example.commonservice.model.OrganizationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Service
public class RestClientService {

    private final RestTemplate restTemplate;

    @Value("${first-service.url}")
    private String serviceUrl;

    @Autowired
    public RestClientService(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    private URI buildURIWithIntervals(String url, String filterMinQuery, String filterMaxQuery) {
        UriComponentsBuilder builder = fromHttpUrl(url);
        builder.queryParam("pageNumber", 0);
        builder.queryParam("pageSize", 0);
        List<String> myList = new ArrayList<>();
        myList.add(filterMinQuery);
        myList.add(filterMaxQuery);

        builder.queryParam("filters", String.join(",", myList));
        return builder.build().encode().toUri();
    }

    public List<OrganizationDTO> getOrganizationsFilteredByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");

        String url = serviceUrl + "/organizations";
        String filterMinQuery = "annualTurnover>=" + minAnnualTurnover.toString();
        String filterMaxQuery = "annualTurnover<=" + maxAnnualTurnover.toString();
        URI uri = buildURIWithIntervals(url, filterMinQuery, filterMaxQuery);

        ResponseEntity<OrganizationDTO[]> response = restTemplate.exchange(uri, HttpMethod.GET,
                new HttpEntity<>(headers), OrganizationDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<OrganizationDTO> getOrganizationsFilteredByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");

        String url = serviceUrl + "/organizations";
        String filterMinQuery = "employeesCount>=" + minEmployeesCount.toString();
        String filterMaxQuery = "employeesCount<=" + maxEmployeesCount.toString();
        URI uri = buildURIWithIntervals(url, filterMinQuery, filterMaxQuery);

        ResponseEntity<OrganizationDTO[]> response = restTemplate.exchange(uri, HttpMethod.GET,
                new HttpEntity<>(headers), OrganizationDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
