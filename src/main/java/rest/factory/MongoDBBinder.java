package rest.factory;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.mongodb.Mongo;

public class MongoDBBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bindFactory(MongoDBFactory.class).to(Mongo.class);
	}

}
