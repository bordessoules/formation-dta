package fr.pizzeria.admin.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/login")
public class LoginResource {
	private static final String MDP ="admin123";
	private static final String LOGIN ="admin";
	@Inject private TokenService tokenService;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("login") String login,@FormParam("mdp") String mdp){
		Response resp =null;
		if (LOGIN.equals(login)&& MDP.equals(mdp)){
			String token =tokenService.generateNEwToken();
			resp=Response.ok(token).build();
		}
		else{
			resp=Response.status(Status.FORBIDDEN).build();
		}
		return resp;
	}
	
}
