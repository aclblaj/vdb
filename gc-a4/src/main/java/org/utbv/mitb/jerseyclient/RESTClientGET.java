package org.utbv.mitb.jerseyclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class RESTClientGET {
    public static void main(String[] args) {
        try {
            Client client = ClientBuilder.newClient();
            String url;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int j2 = 0; j2 < 10; j2++) {
                        url = "http://localhost:8080/gc-a2/rest/message/measure/" + i + "/" + j + "/" + j2;
                        System.out.println(url);
                        WebTarget webTarget = client.target(url);
                        Response response = webTarget.request("application/json").get();
                        if (response.getStatus() != 200) {
                            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
                        }
                        String output = response.readEntity(String.class);
                        System.out.println("Output from Server .... \n");
                        System.out.println(output);
                        response.close();
                    }
                }
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
