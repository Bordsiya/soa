package org.example.controller;

import com.example.commonservice.model.OrganizationDTO;
import org.example.catalog.*;
import org.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Endpoint
public class PingController {
    private static final String NAMESPACE_URI = "http://org/example/secondservicesoap/catalog";

    private ClientService clientService;

    @Autowired
    public PingController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPingRequest")
    @ResponsePayload
    public GetPingResponse getPing(@RequestPayload GetPingRequest request){
        Long id = request.getId();

        System.out.println("id = " + id);

        GetPingResponse response = new GetPingResponse();
        PingGetResponseDto responsePing = new PingGetResponseDto();
        responsePing.setId(id);
        response.setPing(responsePing);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterOrganizationsByAnnualTurnoverRequest")
    @ResponsePayload
    public FilterOrganizationsByAnnualTurnoverResponse filterOrganizationsByAnnualTurnover(@RequestPayload FilterOrganizationsByAnnualTurnoverRequest request) throws DatatypeConfigurationException {
        List<OrganizationDTO> organizationDTOS = clientService.getOrganizationsFilteredByAnnualTurnover(
                request.getMinAnnualTurnover(), request.getMaxAnnualTurnover()
        );

        List<Organization> organizationList = new ArrayList<>();
        for (OrganizationDTO organizationDTO: organizationDTOS) {
            Coordinates coordinates = new Coordinates();
            coordinates.setX(organizationDTO.getCoordinatesDTO().getX());
            coordinates.setY(organizationDTO.getCoordinatesDTO().getY());
            Address address = new Address();
            address.setStreet(organizationDTO.getOfficialAddressDTO().getStreet());
            address.setZipCode(organizationDTO.getOfficialAddressDTO().getZipCode());
            XMLGregorianCalendar xmlGregorianCalendar =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(organizationDTO.getCreationDate().toString());

            Organization organization = new Organization();
            organization.setId(organizationDTO.getId());
            organization.setName(organizationDTO.getName());
            organization.setCoordinates(coordinates);
            organization.setCreationDate(xmlGregorianCalendar);
            organization.setAnnualTurnover(organizationDTO.getAnnualTurnover());
            organization.setOrganizationType(organizationDTO.getType().name());
            organization.setAddress(address);
            organizationList.add(organization);
        }

        FilterOrganizationsByAnnualTurnoverResponse organizationsResponse = new FilterOrganizationsByAnnualTurnoverResponse();
        organizationsResponse.setOrganizations(organizationList);
        return organizationsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterOrganizationsByEmployeesCountRequest")
    @ResponsePayload
    public FilterOrganizationsByEmployeesCountResponse filterOrganizationsByEmployeesCount(@RequestPayload FilterOrganizationsByEmployeesCountRequest request) throws DatatypeConfigurationException {
        List<OrganizationDTO> organizationDTOS = clientService.getOrganizationsFilteredByEmployeesCount(
                request.getMinEmployeesCount(), request.getMaxEmployeesCount()
        );

        List<Organization> organizationList = new ArrayList<>();
        for (OrganizationDTO organizationDTO: organizationDTOS) {
            Coordinates coordinates = new Coordinates();
            coordinates.setX(organizationDTO.getCoordinatesDTO().getX());
            coordinates.setY(organizationDTO.getCoordinatesDTO().getY());
            Address address = new Address();
            address.setStreet(organizationDTO.getOfficialAddressDTO().getStreet());
            address.setZipCode(organizationDTO.getOfficialAddressDTO().getZipCode());
            XMLGregorianCalendar xmlGregorianCalendar =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(organizationDTO.getCreationDate().toString());

            Organization organization = new Organization();
            organization.setId(organizationDTO.getId());
            organization.setName(organizationDTO.getName());
            organization.setCoordinates(coordinates);
            organization.setCreationDate(xmlGregorianCalendar);
            organization.setAnnualTurnover(organizationDTO.getAnnualTurnover());
            organization.setOrganizationType(organizationDTO.getType().name());
            organization.setAddress(address);
            organizationList.add(organization);
        }

        FilterOrganizationsByEmployeesCountResponse organizationsResponse = new FilterOrganizationsByEmployeesCountResponse();
        organizationsResponse.setOrganizations(organizationList);
        return organizationsResponse;
    }
}
