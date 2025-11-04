package org.utbv.mitb.ws;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import org.utbv.mitb.domain.User;
import org.utbv.mitb.domain.UserDao;
import org.utbv.mitb.ws.dto.Client;
import org.utbv.mitb.ws.dto.Inpt;

@Stateless
@Path("/message")
public class MessageRestServices {

	@Inject
	private UserDao userDao;

	// rest/message/vp1
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "ok: " + msg;

		return Response.status(200).entity(result).build();

	}

	// rest/message/getname/aclblaj
	@GET
	@Path("/getname/{param}")
	@Produces("application/json")
	public User getUserName(@PathParam("param") String msg) {
		User result = userDao.getForUsername(msg);
		return result;
	}

	// rest/message/json/vp1/vp2
	@GET
	@Path("/json/{param1}/{param2}")
	@Produces("application/json")
	public Client printJSONMessage(@PathParam("param1") String msg1, @PathParam("param2") String msg2) {

		Client c = new Client();
		c.setName(msg1);
		c.setFirstname(msg2);
		// String result = "Restful example : " + msg;

		return c;
		// Response.status(200).entity(result).build();
	}

	// rest/message/jsonin
	@POST
	@Path("/jsonin")
	@Produces("application/json")
	@Consumes("application/json")
	public Client printJSONMessage3(Inpt in) {

		Client c = new Client();
		c.setName(in.getP1());
		c.setFirstname(in.p2);
		c.setTelephone(in.p3);
		// String result = "Restful example : " + msg;

		return c;
		// Response.status(200).entity(result).build();
	}

}