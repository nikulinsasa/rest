package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class RestHelloWorld {

	@GET
	@Produces("application/json")
	public String getHello()
	{
		return "{\"message\":\"he222llo\"}";
	}
	
}
