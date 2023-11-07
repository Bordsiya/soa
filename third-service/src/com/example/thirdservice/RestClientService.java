package com.example.thirdservice;


import com.example.commonservice.model.OrganizationDTO;
import com.example.commonservice.model.PredictionDTO;
import com.example.commonservice.model.QuarterResponseDTO;
import com.example.thirdservice.exception.JSONException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;

@Slf4j
public class RestClientService {
    private final ObjectMapper objectMapper;

    public RestClientService() {
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

    private Client client;
    private final String serviceUrl = "https://localhost:9099/";

    public QuarterResponseDTO recommendCoordinateQuarter(){
        String url = serviceUrl + "/recommend/coordinates/quarter";
        client = JerseyHttpClientFactory.getJerseyHTTPSClient();

        Response response = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get();

        String quarterResponseDTOString = response.readEntity(String.class);
        QuarterResponseDTO quarterResponseDTO;
        try {
            quarterResponseDTO = objectMapper.readValue(quarterResponseDTOString, QuarterResponseDTO.class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e.getMessage());
        }

        client.close();

        return quarterResponseDTO;
    }

    public PredictionDTO predictOrganizationAnnualTurnoverBehavior(Integer id) {
        String url = serviceUrl + "/predict/organizations/{id}/annual-turnover";
        client = JerseyHttpClientFactory.getJerseyHTTPSClient();

        UriComponentsBuilder builder = fromHttpUrl(url);

        log.info("uri = " + builder.buildAndExpand(id).encode().toUri());

        Response response = client.target(builder.buildAndExpand(id).encode().toUri()).request(MediaType.APPLICATION_JSON_TYPE).get();

        String predictionDTOString = response.readEntity(String.class);
        PredictionDTO predictionDTO;
        try {
            predictionDTO = objectMapper.readValue(predictionDTOString, PredictionDTO.class);
        } catch (JsonProcessingException e) {
            throw new JSONException(e.getMessage());
        }

        client.close();

        return predictionDTO;
    }

    public List<OrganizationDTO> recommendOrganizationsByCoordinates(Double x, Long y) {
        String url = serviceUrl + "/recommend/organizations/coordinates";
        client = JerseyHttpClientFactory.getJerseyHTTPSClient();

        UriComponentsBuilder builder = fromHttpUrl(url);
        builder.queryParam("x", x);
        builder.queryParam("y", y);

        Response response = client.target(builder.build().encode().toUri()).request(MediaType.APPLICATION_JSON_TYPE).get();

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
