package com.abab.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


 

 
@Path("/fibonacci")
public class FibonacciService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String param) {
 
		
		

		StringBuffer sb = new StringBuffer();
		
		
		
		int n1=0,n2=1,n3,i,count=10;
		
		count = Integer.parseInt(param);
		
		if( count <= 0){
		
			sb.append("Please Enter Positive Integers");
			
		}else{
			
			if( count == 1){
				
				return Response.status(200).entity(n1).build();
			}else if(count == 2){
				
				return Response.status(200).entity(n1+","+n2).build();
			}
			sb.append(n1+","+n2); //printing 0 and 1
			
			for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed    
			{
				n3=n1+n2;
				sb.append(","+n3);
		        n1=n2;
				n2=n3;
			}
		}
 
		return Response.status(200).entity(sb.toString()).build();
 
	}
	
	
 
}