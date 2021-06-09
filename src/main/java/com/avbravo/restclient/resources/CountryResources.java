/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.resources;

import com.avbravo.restclient.domains.Country;
import com.avbravo.restclient.repository.CountryRepository;
import java.util.ArrayList;
import java.util.Arrays;
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
               return countryRepository.first();
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
    public Response add(Country  country ){
        if(countryRepository.save(country )){
            return Response.status(201).entity("Ok").build();
        }else{
            return Response.status(400).entity("error ").build();
        }
    }
    
    
    
    
    
      // <editor-fold defaultstate="collapsed" desc="@Path("/update")">
    @PUT
    @Path("/update")
//    @RolesAllowed({"admin"})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Country country ) {
        try {

            if (countryRepository.update(country )) {
                return Response.status(201).entity("Ok").build();
            }
            return Response.status(400).entity("Error").build();
        } catch (Exception e) {
            return Response.status(400).entity("Error!!" + e.getLocalizedMessage()).build();

        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="@Path("/delete")">
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Country country ) {
        try {

            if (countryRepository.delete(country )) {
                return Response.status(201).entity("Ok").build();
            }

            return Response.status(400).entity("Error ").build();
        } catch (Exception e) {
            return Response.status(400).entity("Ocurrio un error!!" + e.getLocalizedMessage()).build();
        }

    }
    // </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="@Path("/search/{idcountry }")">
//
//    @GET
//    @Path("/search/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Country findByIdcountry (@PathParam("id") String id) {
//        Country country = new Country ();
//        try {
//            country .setId(id);
//            Optional<Country > optional = countryRepository.findById(country );
//            if (optional.isPresent()) {
//                country = optional.get();
//
//            }
//        } catch (Exception e) {
//            System.out.println("findById) " + e.getLocalizedMessage());
//            
//        }
//
//        return country ;
//    }
//// </editor-fold>


   
//  // <editor-fold defaultstate="collapsed" desc=" @Path("/jsonquery")">
//    /**
//     * Recive json para consulta y ordenaciones y paginacion y realiza la
//     * busqueda
//     *
//     * @param query
//     * @param sort
//     * @param pageNumber
//     * @param rowForPage
//     * @return
//     */
//    @GET
//    @Path("/jsonquery")
//    @RolesAllowed({"admin"})
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//
//    public List<Country > jsonQuery(@QueryParam("query") String query, @QueryParam("sort") String sort,
//            @QueryParam("pagenumber") Integer pageNumber, @QueryParam("rowforpage") Integer rowForPage) {
//        List<Country > suggestions = new ArrayList<>();
//        try {
//
//            Document docQuery = country Repository.jsonToDocument(query);
//            Document docSort = country Repository.jsonToDocument(sort);
//
//            suggestions = country Repository.findPagination(docQuery, pageNumber, rowForPage, docSort);
//
//        } catch (Exception e) {
//            System.out.println(JmoordbUtil.nameOfMethod() + " " + e.getLocalizedMessage());
//            
//
//        }
//
//        return suggestions;
//    }
//
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="     @Path("/jsonquerywithoutpagination")">
//    /**
//     * Hace cosultas sin paginacion
//     *
//     * @param query
//     * @param sort
//     * @return
//     */
//    @GET
//    @Path("/jsonquerywithoutpagination")
//    @RolesAllowed({"admin"})
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//
//    public List<Country > jsonQueryWithoutPagination(@QueryParam("query") String query, @QueryParam("sort") String sort) {
//        List<Country > suggestions = new ArrayList<>();
//        try {
//
//            Document docQuery = country Repository.jsonToDocument(query);
//            Document docSort = country Repository.jsonToDocument(sort);
//
//            suggestions = country Repository.findBy(docQuery, docSort);
//
//        } catch (Exception e) {
//            System.out.println(JmoordbUtil.nameOfMethod() + " " + e.getLocalizedMessage());
//
//        }
//
//        return suggestions;
//    }
//
//// </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc=" Response countJsonQuery((@QueryParam("query") String query)">
//    /**
//     * Cuenta el numero de registros 
//     * @param query
//     * @return 
//     */
//    @GET
//    @Path("/countjsonquery")
//    @RolesAllowed({"admin"})
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//
//    public Response countJsonQuery(@QueryParam("query") String query) {
//        List<Country > suggestions = new ArrayList<>();
//        try {
//
//            Document docQuery = country Repository.jsonToDocument(query);
//            Integer total = 0;
//
//            total = country Repository.count(docQuery);
//            return Response.status(201).entity(total).build();
//
//        } catch (Exception e) {
//
//           
//            return Response.status(400).entity("error: " + country Repository.getException().getLocalizedMessage()).build();
//        }
//    }
//
//// </editor-fold>
    
}
