package org.utbv.mitb.ws;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.utbv.mitb.domain.User;
import org.utbv.mitb.domain.UserDao;
import org.utbv.mitb.ws.dto.Answer;

@RequestScoped
@Path("/gc/login")
public class LoginWebServices {

	private final static Logger logger = LoggerFactory.getLogger(LoginWebServices.class);

	@Inject
	private UserDao appuserejb;

	private static Answer answer = new Answer();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// @Produces(MediaType.APPLICATION_JSON)
	public void registerAppuser(MultivaluedMap<String, String> appuserParams) {
		logger.info("Entered to login web service.");
		if (appuserParams.getFirst("securityphrase") == null) {
			String username = appuserParams.getFirst("username");
			String password = appuserParams.getFirst("password");

			User appuser = appuserejb.find(username, password);
			answer.setAnswer("Success !");
			if (appuser == null) {
				appuser = appuserejb.find(username);
				answer.setAnswer("Incorrect password !");
				if (appuser == null) {
					System.out.println("user");
					answer.setAnswer("User " + username + " doesn't exist !");
				}
			}
		} else {
			String username = appuserParams.getFirst("username");
			String securityphrase = appuserParams.getFirst("securityphrase");

			User appuser = appuserejb.find(username, securityphrase, "check");
			answer.setAnswer("Success !");
			if (appuser == null) {
				answer.setAnswer("Close !");
			}
		}
		// return appuser;
	}

	@GET
	@Path("answer")
	@Produces(MediaType.APPLICATION_JSON)
	public Answer getAnswer() {
		return answer;
	}
}
