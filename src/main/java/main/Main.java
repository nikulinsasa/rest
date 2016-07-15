package main;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import org.glassfish.jersey.server.ResourceConfig;

import org.glassfish.jersey.simple.SimpleContainerFactory;
import org.glassfish.jersey.simple.SimpleServer;

//import com.sun.net.httpserver.HttpHandler;

//import rest.MyApplication;
import rest.MyResources;

public class Main {

	public static void main(String[] args){
		
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
//	    ResourceConfig config = new ResourceConfig(MyResources.class);
	    
	    SimpleContainerFactory.create(baseUri, new MyResources());
	    
//		RuntimeDelegate.getInstance().createEndpoint(config, HttpHandler.class);
		
	}
	
}
