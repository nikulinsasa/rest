package rest.factory;

import java.net.UnknownHostException;


import org.glassfish.hk2.api.Factory;

import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoDBFactory implements Factory<Mongo> {

	
	
	public void dispose(Mongo arg0) {
		
	}

	public Mongo provide() {
		
		try {
			return new Mongo("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			System.out.println("Неизвестный хост "+e.getMessage());
		} catch (MongoException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

}
