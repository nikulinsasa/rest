package rest.test;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.ObjectId;

@Path("/mongo")
public class MongoRest {

	@Inject
	Mongo mongo;

	@GET
	@Produces("application/json")
	public String getHello() {
		try {
			DB dataBase = mongo.getDB("test");
			
			DBCollection result = dataBase.getCollection("test");
			
			StringBuffer sb = new StringBuffer();
			
			List<DBObject> _list = result.find().toArray();

			if(_list.isEmpty()){
				return "{\"result\":\"nothin was found\"}";
			}
			
			for(int i=0;i<_list.size();i++){
				sb.append(_list.get(i).toString());
			}
			
			return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
			return "{\"error\":\""+e.getMessage()+"\"}";
		}
		
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String insertData(String query)
	{
		DB dataBase = mongo.getDB("test");
		DBCollection collection = dataBase.getCollection("test");
		
		DBObject doc = new BasicDBObject();
		doc.put("name", "test1");
		collection.insert(doc);
		
		DBCursor cursor = collection.find();
		
		return cursor.next().toString();
	}
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public String getById(@PathParam("id") String id)
	{
		
		
		DB dataBase = mongo.getDB("test");
		DBCollection collection = dataBase.getCollection("test");
		
		return collection.findOne(createObjectById(id)).toString();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public String updateData(@PathParam("id") String id,String query)
	{
		
		if(id==null){
			return "{\"error\":\"id is absent\"}";
		}
		
		DB dataBase = mongo.getDB("test");
		DBCollection collection = dataBase.getCollection("test");
		
		BasicDBObject searchingObject = this.createObjectById(id);
		
		DBObject doc = new BasicDBObject();
		doc.put("name", "test2");
		collection.update(
				searchingObject,
				new BasicDBObject("$set",doc)
				);
		
		return collection.findOne(searchingObject).toString();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public String removeElement(@PathParam("id") String id)
	{
		try{
			DB dataBase = mongo.getDB("test");
			DBCollection collection = dataBase.getCollection("test");
			collection.remove(createObjectById(id));	
			return "{\"message\":\"remove is ok\"}";
		}catch(Exception e){
			return "{\"error\":\""+e.getMessage()+"\"}";
		}
	}
	
	private BasicDBObject createObjectById(String id)
	{
		return new BasicDBObject("_id",new ObjectId(id));
	}
	
}
