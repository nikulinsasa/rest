package rest.test;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

@Path("/mongo")
public class MongoRest {

	@Inject
	Mongo mongo;

	@GET
	@Produces("application/json")
	public String getHello() {
		try {
			System.out.println("mongo");
			DB dataBase = mongo.getDB("rest");
			System.out.println("???" + dataBase.getLastError());
			DBObject result = dataBase.command("db.test.find()");
			return result.toString();
		} catch (Exception e) {
			System.out.println(e);
			return "{\"error\":\""+e.getMessage()+"\"}";
		}
		
	}

}
