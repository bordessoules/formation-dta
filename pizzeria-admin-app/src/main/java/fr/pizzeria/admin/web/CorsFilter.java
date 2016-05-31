package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext req, ContainerResponseContext resp) throws IOException {
		req.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:8081");
	}

}
