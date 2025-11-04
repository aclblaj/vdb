package org.utbv.mitb.jerseyclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class RESTClientPOST {
    public static void main(String[] args) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("http://localhost:8080/gc-a2/rest/message/jsonin");
            String input = "{\"p1\":\"v1\",\"p2\":\"v2\",\"p3\":\"v3\"}";
            //create random input
            input = "{";
            for (int i = 1; i < 4; i++) {
                input += "\"param" + i + "\":\"value" + Math.random() * 100 + "\"";
                if (i < 3) {
                    input += ",";
                }
            }
            input += "}";
            Response response = webTarget.request("application/json")
                .post(Entity.json(input));
            if (response.getStatus() != 201 && response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            System.out.println("Output from Server .... \n");
            String output = response.readEntity(String.class);
            System.out.println(output);
            response.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
