package org.example.controller;

import org.example.catalog.GetPingRequest;
import org.example.catalog.GetPingResponse;
import org.example.catalog.PingGetResponseDto;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


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
}
