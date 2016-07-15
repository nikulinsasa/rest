package rest.factory;

import org.glassfish.hk2.api.Factory;

import com.mongodb.Mongo;

public class MongoDBFactory implements Factory<Mongo> {

	private Mongo client;
	
	public void dispose(Mongo arg0) {
		client = arg0;
	}

	public Mongo provide() {
		return client;
	}

}
