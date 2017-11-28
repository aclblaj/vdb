package org.utbv.mitb.jerseyclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTClientGET {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8580/gc-a2/rest/sensor/save/1/2/3");
//http://localhost:8080/gc-a2/rest/message/measure/0.55/2.5/1.5
			String url ="http://localhost:8080/gc-a2/rest/message/measure/";
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					for (int j2 = 0; j2 < 10; j2++) {
						url ="http://localhost:8080/gc-a2/rest/message/measure/";
						url = url + i+"/" +j+"/"+j2;
						System.out.println(url);
						webResource = client.resource(url);
						ClientResponse response = webResource.accept("application/json")
				                   .get(ClientResponse.class);

						if (response.getStatus() != 200) {
						   throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
						}

						String output = response.getEntity(String.class);

						System.out.println("Output from Server .... \n");
						System.out.println(output);
					}
				}
			}
			

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
}
