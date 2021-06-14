package com.avbravo.restclient;
import com.avbravo.jmoordb.configuration.JmoordbConnection;
import java.util.Optional;

import java.util.Set;
import javax.inject.Inject;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("resources")
@BasicAuthenticationMechanismDefinition(realmName = "admin-realm")
public class JAXRSConfiguration extends Application {
 @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        try {
            JmoordbConnection jmc = new JmoordbConnection.Builder()
                    .withSecurity(false)
                    .withDatabase("mydatabase")
                    .withHost("")
                    .withPort(0)
                    .withUsername("")
                    .withPassword("")
                    .build();
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }

        return resources;
    }
}