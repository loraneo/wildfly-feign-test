package com.test.test1;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(value = "application/vnd.github.machine-man-preview+json")
@Produces(value = MediaType.APPLICATION_JSON)
interface GitHub {

	@GET
	@Path("/repos/{installation_id}/access_tokens")
	List<String> getAccessToken(@PathParam("installation_id") String installationId,
			@HeaderParam("Authorization") String jwtKey);
}
