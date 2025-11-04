package org.utbv.mitb.ws;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.utbv.mitb.domain.User;
import org.utbv.mitb.domain.UserDao;
import org.utbv.mitb.ws.dto.Answer;


@RequestScoped
@Path("/gc")
public class UserWebServices {

	private final static Logger logger = LoggerFactory.getLogger(UserWebServices.class);

	@Inject
	private UserDao appuserejb;
	private static Answer answer = new Answer();

	@GET
	@Path("first")
	@Produces(MediaType.APPLICATION_JSON)
	public User getTabel() {

		System.out.println("Return Appuser: " + appuserejb.getAppuser().getFirstName());

		return appuserejb.getAppuser();
	}

	@GET
	@Path("answer")
	@Produces(MediaType.APPLICATION_JSON)
	public Answer getAnswer() {
		return answer;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User registerAppuser(MultivaluedMap<String, String> appuserParams) {
		logger.info("Entered to register new user web service.");
		String firstname = appuserParams.getFirst("firstname");
		String lastname = appuserParams.getFirst("lastname");
		String username = appuserParams.getFirst("username");
		String password = appuserParams.getFirst("password");
		String phone = appuserParams.getFirst("phone");
		String email = appuserParams.getFirst("email");
		String securityphrase = appuserParams.getFirst("securityphrase");

		long id = appuserejb.getMaxId();

		User appuser = new User();
		appuser.setId(++id);
		appuser.setFirstName(firstname);
		appuser.setLastName(lastname);
		appuser.setUsername(username);
		appuser.setPassword(password);
		appuser.setPhone(phone);
		appuser.setEmail(email);
		appuser.setSecurityphrase(securityphrase);

		logger.info("Return answer from the register new user web service.");
		answer.setAnswer(appuserejb.createUser(appuser));

		return appuser;
	}
}
