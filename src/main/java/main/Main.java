package main;

import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.simple.SimpleContainerFactory;

import rest.MyResources;

public class Main {

	public static void main(String[] args){
		
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
	    
	    SimpleContainerFactory.create(baseUri, new MyResources());
		
	}
	
}
