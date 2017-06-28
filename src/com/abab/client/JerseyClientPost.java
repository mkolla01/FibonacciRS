package com.abab.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class JerseyClientPost {

	/**
	 * This is working example.
	 * @param args
	 * @throws Exception
	 */
  public static void main1(String[] args) {

    try {
    	
    	ClientConfig clientConfig = new ClientConfig();
    	Client client = ClientBuilder.newClient(clientConfig);
    	
    	WebTarget webTarget = client.target("http://localhost:8080/FibonacciRS");
    	
    	WebTarget resourceWebTarget = webTarget.path("rest");
    	
    	WebTarget fibonacciWebTarget = resourceWebTarget.path("fibonacci");
    	
    	System.out.println(" Query String : "+ fibonacciWebTarget.getUri());
        
    	WebTarget fibonacciWebTargetWithQueryParam = fibonacciWebTarget.queryParam("param","10");
    	
    	System.out.println(" Query String : "+ fibonacciWebTargetWithQueryParam.getUri());
  
    	Invocation.Builder invocationBuilder =   fibonacciWebTargetWithQueryParam.request(MediaType.TEXT_PLAIN_TYPE);
    	
    	invocationBuilder.header("some-header", "true");
    	
    	Response response = invocationBuilder.get();
    	
    	System.out.println(response.getStatus());
    	
    	System.out.println(response.readEntity(String.class));

      } catch (Exception e) {

        e.printStackTrace();

      }
}

/**
 * This is working example.
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception{
  
	  Client client;
	  WebTarget userTarget;
	  //WebTarget userRepoTarget;
	  
	  client = ClientBuilder.newClient();
      
      userTarget = client.target("http://localhost:8080/FibonacciRS/rest/fibonacci/10");
      //userRepoTarget = client.target("http://localhost:8080/HelloWorldRS3_0/rest/helloworld/{username}");
  
      Response res = userTarget.request("application/xml").get();
  	System.out.println(res.readEntity(String.class));
  	
  	/**
  	 * OutPut look like this :
  	 * Jersey say : srinivas}
  	 */
      
  }
 
}
