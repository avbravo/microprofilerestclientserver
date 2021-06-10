/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.resources;
import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.avbravo.jmoordb.util.JmoordbUtil;
import com.avbravo.restclient.entity.Country;
import com.avbravo.restclient.repository.CountryRepository;
import static com.couchbase.client.java.query.N1qlParams.build;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;
/**
 *
 * @author avbravo
 */
@Path("/message")
public class CountryResources {

    @Inject
    CountryRepository countryRepository;

    @GET
    @Path("/text")
    public String getHello() {
        return "hello world from Rest Client!";
    }

    @GET
    @Path("/first")
    @Produces(MediaType.APPLICATION_JSON)
    public Country first() {
        return countryRepository.findAll().get(0);
    }

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Country country) {
        try {
            if (countryRepository.save(country)) {
               
                return Response.status(201).entity("Ok").build();
            } else {
               
                return Response.status(400).entity("error "+countryRepository.getException().getLocalizedMessage()).build();
            }
        } catch (Exception e) {
            return Response.status(400).entity("Error!!" + e.getLocalizedMessage()).build();

        }
    }

    
    
    
    // <editor-fold defaultstate="collapsed" desc="@Path("/update")">
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Country country) {
        try {

            if (countryRepository.update(country)) {
             
                return Response.status(201).entity("Ok").build();
            }
            
              return Response.status(400).entity("error "+countryRepository.getException().getLocalizedMessage()).build();
        } catch (Exception e) {
            return Response.status(400).entity("Error!!" + e.getLocalizedMessage()).build();

        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="@Path("/delete")">
   
//    @Path("/delete")
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) {
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response delete(Country country) {
        try {
           Document doc = new Document("id",id);
//            if (countryRepository.delete(country)) {
            if (countryRepository.delete(doc)) {
           
                return Response.status(201).entity("Ok").build();
            }
           
             return Response.status(400).entity("error "+countryRepository.getException().getLocalizedMessage()).build();
        } catch (Exception e) {
            return Response.status(400).entity("Ocurrio un error!!" + e.getLocalizedMessage()).build();
        }

    }
    // </editor-fold>
    
   
    
    
//    // <editor-fold defaultstate="collapsed" desc="@Path("/search/{idcountry }")">

    @GET
    @Path("/search/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country findById(@PathParam("id") String id) {
        Country country = new Country();
        try {
            
            System.out.println("---->buscare id "+id);
            country.setId(id);
            Optional<Country> optional = countryRepository.findById(country);
            if (optional.isPresent()) {
                System.out.println("---> encontrado");
                country = optional.get();
                System.out.println("----> name "+country.getName());
            }
        } catch (Exception e) {
            System.out.println("findById) " + e.getLocalizedMessage());

        }

        return country;
    }
//// </editor-fold>

}
