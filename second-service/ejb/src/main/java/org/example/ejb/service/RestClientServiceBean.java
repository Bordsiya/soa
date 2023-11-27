package org.example.ejb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.extern.slf4j.Slf4j;
import org.example.ejb.model.OrganizationDTO;
import org.example.ejb.exception.JSONException;
import org.example.ejb.external.HttpClientFactory;
import org.jboss.ejb3.annotation.Pool;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Stateless
@Remote(RestClientService.class)
@Pool(value = "restClientServicePool")
public class RestClientServiceBean implements RestClientService {
    private Client client;
    private final String serviceUrl = "https://haproxy-for-first-service:9200";
    private final ObjectMapper objectMapper;

    public RestClientServiceBean() {
        JavaTimeModule module = new JavaTimeModule();
        LocalDateDeserializer localDateTimeDeserializer =  new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addDeserializer(LocalDate.class, localDateTimeDeserializer);
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        module.addSerializer(localDateSerializer);
        objectMapper = new ObjectMapper().registerModule(module).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private URI buildURIWithIntervals(String urlHost, String filterMinQuery, String filterMaxQuery) {
        try {
            String parameters = "filters=" + filterMinQuery + "&filters=" + filterMaxQuery + "&pageNumber=0&pageSize=0";
            URL url = new URL(urlHost + "?" + parameters);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        }
        catch (MalformedURLException | URISyntaxException e) {
            log.error("-------------------uri problems----------------");
            log.error(e.getMessage());
        }
        return null;
    }

    public List<OrganizationDTO> getOrganizationsFilteredByAnnualTurnover(Double minAnnualTurnover, Double maxAnnualTurnover) {
        client = HttpClientFactory.getJerseyHTTPSClient();

        String url = serviceUrl + "/organizations";
        String filterMinQuery = "annualTurnover>=" + minAnnualTurnover;
        String filterMaxQuery = "annualTurnover<=" + maxAnnualTurnover;
        URI uri = buildURIWithIntervals(url, filterMinQuery, filterMaxQuery);

        log.error("-------------" + uri.toASCIIString() + "---------------");


        Response response = client.target(uri).request(MediaType.APPLICATION_JSON_TYPE).get();
        String organizationsDTOString = response.readEntity(String.class);
        log.error("--------------------" + organizationsDTOString + "---------------------");
        OrganizationDTO[] organizationDTOS;
        try {
            organizationDTOS = objectMapper.readValue(organizationsDTOString, OrganizationDTO[].class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e.getMessage());
        }
        client.close();

        return Arrays.asList(organizationDTOS);
    }

    public List<OrganizationDTO> getOrganizationsFilteredByEmployeesCount(Long minEmployeesCount, Long maxEmployeesCount) {
        client = HttpClientFactory.getJerseyHTTPSClient();

        String url = serviceUrl + "/organizations";
        String filterMinQuery = "employeesCount>=" + minEmployeesCount;
        String filterMaxQuery = "employeesCount<=" + maxEmployeesCount;
        URI uri = buildURIWithIntervals(url, filterMinQuery, filterMaxQuery);

        log.error("-------------" + uri.toASCIIString() + "---------------");

        Response response = client.target(uri).request(MediaType.APPLICATION_JSON_TYPE).get();
        String organizationsDTOString = response.readEntity(String.class);
        log.error("--------------------" + organizationsDTOString + "---------------------");
        OrganizationDTO[] organizationDTOS;
        try {
            organizationDTOS = objectMapper.readValue(organizationsDTOString, OrganizationDTO[].class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e.getMessage());
        }
        client.close();

        return Arrays.asList(organizationDTOS);
    }
}
