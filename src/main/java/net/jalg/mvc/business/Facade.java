package net.jalg.mvc.business;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.jalg.mvc.core.Template;

@Path("user/{userId}/account")
public class Facade {
	@PathParam("userId") String userId;
	
	@GET
	@Produces("text/html")
	@Path("contract-details")
	@Template("templates/contract.vm")
	public Contract getContractDetails() {
		return new Contract("123456", userId, "new");
	}
}
