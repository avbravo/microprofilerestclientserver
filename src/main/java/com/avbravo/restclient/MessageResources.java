/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author avbravo
 */
@Path("/message")
public class MessageResources {
  @GET
	@Path("/text")
	public String getHello () 
	{
		return "hello world from Rest Client!";
	} 
	
	
}
