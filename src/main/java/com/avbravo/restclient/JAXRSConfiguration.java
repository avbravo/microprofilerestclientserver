package com.avbravo.restclient;
import com.avbravo.jmoordb.configuration.JmoordbConnection;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
 @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        try {
//            JmoordbConnection jmc = new JmoordbConnection.Builder()
//                    .withSecurity(false)
//                    .withDatabase("autentification")
//                    .withHost("locahost")
//                    .withPort(27017)
//                    .withUsername("")
//                    .withPassword("")
//                    .withUri("")
//                    .build();
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }

        return resources;
    }
}