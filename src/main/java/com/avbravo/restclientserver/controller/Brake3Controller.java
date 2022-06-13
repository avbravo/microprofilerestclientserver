/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.restclientserver.controller;

import com.avbravo.jmoordbutils.crypto.blake3.JmoordbUtilsBlake3;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author avbravo
 */
@Path("/brake3")
public class Brake3Controller {
    
 // <editor-fold defaultstate="collapsed" desc="@Path("/search/{idcountry }")">
    @GET
    @Path("/key/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String key(@PathParam("id") String id) {
     String encripter = ""; 
        try {
       encripter=    JmoordbUtilsBlake3.encripter(id, 256);
           
        } catch (Exception e) {
            System.out.println("key() " + e.getLocalizedMessage());

        }

        return encripter;
    }
//// </editor-fold>

}
