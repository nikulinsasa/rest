package rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import rest.factory.MongoDBBinder;

@ApplicationPath("resources")
public class MyResources extends ResourceConfig {

	public MyResources() {
		packages("rest.test");
//		register(RestHelloWorld.class);
		register(org.glassfish.jersey.server.filter.UriConnegFilter.class);
//        register(org.glassfish.jersey.server.validation.ValidationFeature.class);
//        register(org.glassfish.jersey.server.spring.SpringComponentProvider.class);
        register(org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainerProvider.class);
        register(new MongoDBBinder());
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
	}
	
}
