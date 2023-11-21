package org.example.ejb.service;

import lombok.extern.slf4j.Slf4j;
import org.example.ejb.model.OrganizationDTO;
import org.example.ejb.exception.JSONException;
import org.example.ejb.external.HttpClientFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Slf4j
@Stateless(name = "RestClientService")
public class RestClientServiceBean implements RestClientService {
    private Client client;
    private final String serviceUrl = "https://localhost:9099/";
    private final ObjectMapper objectMapper;

    public RestClientServiceBean() {
        JavaTimeModule module = new JavaTimeModule();
        LocalDateDeserializer localDateTimeDeserializer =  new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addDeserializer(LocalDate.class, localDateTimeDeserializer);
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addSerializer(localDateSerializer);
        objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(module)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
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
        client = HttpClientFactory.getJerseyHTTPSClient();

        String url = serviceUrl + "/organizations";
        String filterMinQuery = "annualTurnover>=" + minAnnualTurnover.toString();
        String filterMaxQuery = "annualTurnover<=" + maxAnnualTurnover.toString();
        URI uri = buildURIWithIntervals(url, filterMinQuery, filterMaxQuery);

        Response response = client.target(uri).request(MediaType.APPLICATION_JSON_TYPE).get();
        String organizationsDTOString = response.readEntity(String.class);
        OrganizationDTO[] organizationDTOS;
        try {
            organizationDTOS = objectMapper.readValue(organizationsDTOString, OrganizationDTO[].class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e.getMessage());
        }

        client.close();
        return Arrays.asList(Objects.requireNonNull(organizationDTOS));
    }

    public List<OrganizationDTO> getOrganizationsFilteredByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        client = HttpClientFactory.getJerseyHTTPSClient();

        String url = serviceUrl + "/organizations";
        String filterMinQuery = "employeesCount>=" + minEmployeesCount.toString();
        String filterMaxQuery = "employeesCount<=" + maxEmployeesCount.toString();
        URI uri = buildURIWithIntervals(url, filterMinQuery, filterMaxQuery);

        Response response = client.target(uri).request(MediaType.APPLICATION_JSON_TYPE).get();
        String organizationsDTOString = response.readEntity(String.class);
        OrganizationDTO[] organizationDTOS;
        try {
            organizationDTOS = objectMapper.readValue(organizationsDTOString, OrganizationDTO[].class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e.getMessage());
        }

        client.close();
        return Arrays.asList(Objects.requireNonNull(organizationDTOS));
    }
}
