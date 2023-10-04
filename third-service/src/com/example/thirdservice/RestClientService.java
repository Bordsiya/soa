package com.example.thirdservice;


public class RestClientService {
    /*
    private Client client;
    private final String serviceUrl = "https://localhost:9099/api/v1";

    public QuarterResponseDTO recommendCoordinateQuarter() {
        String url = serviceUrl + "/recommend/coordinates/quarter";
        try {
            client = JerseyHttpClientFactory.getJerseyHTTPSClient();

            Response response = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get();

            QuarterResponseDTO quarterResponseDTO = response.readEntity(QuarterResponseDTO.class);

            client.close();

            return quarterResponseDTO;

        } catch (ProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PredictionDTO predictOrganizationAnnualTurnoverBehavior(Integer id) {
        String url = serviceUrl + "/predict/organizations/{id}/annual-turnover";
        try {
            client = JerseyHttpClientFactory.getJerseyHTTPSClient();

            Response response = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get();

            PredictionDTO predictionDTO = response.readEntity(PredictionDTO.class);

            client.close();

            return predictionDTO;

        } catch (ProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OrganizationDTO> recommendOrganizationsByCoordinates(Double x, Long y) {
        String url = serviceUrl + "/recommend/organizations/coordinates";
        try {
            client = JerseyHttpClientFactory.getJerseyHTTPSClient();

            Response response = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get();

            OrganizationDTO[] organizationDTOS = response.readEntity(OrganizationDTO[].class);

            client.close();

            return Arrays.asList(Objects.requireNonNull(organizationDTOS));

        } catch (ProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
     */
}
