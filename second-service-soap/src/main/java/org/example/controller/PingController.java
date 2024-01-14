package org.example.controller;

import org.example.catalog.*;
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
        List<Organization> organizationList = new ArrayList<>();
        Coordinates coordinates1 = new Coordinates();
        coordinates1.setX(1D);
        coordinates1.setY(3);
        Address address1 = new Address();
        address1.setStreet("Street1");
        address1.setZipCode("3746");
        GregorianCalendar calendar1 = new GregorianCalendar(2018, Calendar.JULY, 28);
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar XMLGregorianCalendar1 = datatypeFactory
                .newXMLGregorianCalendar(calendar1);

        Organization organization1 = new Organization();
        organization1.setId(1);
        organization1.setName("Organization1");
        organization1.setCoordinates(coordinates1);
        organization1.setCreationDate(XMLGregorianCalendar1);
        organization1.setAnnualTurnover(20000D);
        organization1.setOrganizationType("ORG_TYPE");
        organization1.setAddress(address1);
        organizationList.add(
                organization1
        );

        FilterOrganizationsByAnnualTurnoverResponse organizationsResponse = new FilterOrganizationsByAnnualTurnoverResponse();
        List<Organization> toAdd = organizationsResponse.getOrganizations();
        toAdd.add(organization1);
        return organizationsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "filterOrganizationsByEmployeesCountRequest")
    @ResponsePayload
    public FilterOrganizationsByEmployeesCountResponse filterOrganizationsByEmployeesCount(@RequestPayload FilterOrganizationsByEmployeesCountRequest request) throws DatatypeConfigurationException {
        List<Organization> organizationList = new ArrayList<>();
        Coordinates coordinates1 = new Coordinates();
        coordinates1.setX(1D);
        coordinates1.setY(3);
        Address address1 = new Address();
        address1.setStreet("Street1");
        address1.setZipCode("3746");
        GregorianCalendar calendar1 = new GregorianCalendar(2018, Calendar.JULY, 28);
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar XMLGregorianCalendar1 = datatypeFactory
                .newXMLGregorianCalendar(calendar1);

        Organization organization1 = new Organization();
        organization1.setId(1);
        organization1.setName("Organization1");
        organization1.setCoordinates(coordinates1);
        organization1.setCreationDate(XMLGregorianCalendar1);
        organization1.setAnnualTurnover(20000D);
        organization1.setOrganizationType("ORG_TYPE");
        organization1.setAddress(address1);
        organizationList.add(
                organization1
        );

        FilterOrganizationsByEmployeesCountResponse organizationsResponse = new FilterOrganizationsByEmployeesCountResponse();
        List<Organization> toAdd = organizationsResponse.getOrganizations();
        toAdd.add(organization1);
        return organizationsResponse;
    }
}
