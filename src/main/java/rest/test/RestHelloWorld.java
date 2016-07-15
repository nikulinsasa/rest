package rest.test;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/helloworld")
public class RestHelloWorld {

	@GET
	@Produces("application/json")
	public String getHello()
	{
		return "{\"message\":\"he222llo\"}";
	}
	
	@GET
	@Produces("application/json")
	@Path("/{username}")
	public String getHello(
			@PathParam("username") String userName,
			@DefaultValue("2") @QueryParam("step") int step
			)
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"name\":");
		sb.append("\"");
		sb.append(userName);
		sb.append("\"");
		sb.append("}");
		System.out.println(step);
		return sb.toString();
	}
	
}
