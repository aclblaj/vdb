package org.utbv.mitb.jerseyclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTClientPOST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8580/gc-a2/rest/message/jsonin");

			String input = "{\"p1\":\"v1\",\"p2\":\"v2\",\"p3\":\"v3\"}";

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}

}
