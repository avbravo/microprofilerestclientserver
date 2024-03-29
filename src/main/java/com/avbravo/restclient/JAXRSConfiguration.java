package com.avbravo.restclient;

import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("api")
@DeclareRoles({ "admin", "testing" })
@BasicAuthenticationMechanismDefinition(realmName = "admin-realm")
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