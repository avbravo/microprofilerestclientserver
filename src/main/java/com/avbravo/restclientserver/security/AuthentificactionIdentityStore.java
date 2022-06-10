/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclientserver.security;
import com.avbravo.jmoordb.util.JmoordbUtil;
import com.avbravo.jmoordbutils.JsfUtil;
import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class AuthentificactionIdentityStore implements IdentityStore {

    String userAutentification;
    String passwordAutentification;
    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    //otp
    @Inject
    @ConfigProperty(name = "userSecurity", defaultValue = "")
    private String userSecurity;
    @Inject
    @ConfigProperty(name = "passwordSecurity", defaultValue = "")
    private String passwordSecurity;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init">

    @PostConstruct
    public void init() {

    }
    // </editor-fold>

    // </editor-fold> 
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        try {
            System.out.println("----------------UsernamePasswordCredential---------------------------------");
            System.out.println("usernamePasswordCredential.getCaller() "+usernamePasswordCredential.getCaller());
            System.out.println("usernamePasswordCredential.getPasswordAsString() "+usernamePasswordCredential.getPasswordAsString());
            System.out.println("---> voy a encriptar ...username");
       String userencripter=    JmoordbUtil.encriptar("E$g3t1.q4@n5", "JaM$x18#man12!*rWs");
       System.out.println("---> voy a encriptar ...password");
      String passwordencripter=     JmoordbUtil.encriptar("s7_$4wnT1den4=/pana1e1", "JaM$x18#man12!*rWs");
            System.out.println("userencripter "+userencripter);
            System.out.println("userencripter "+passwordencripter);
           
            
            System.out.println("-------------------------------------------------");
//            System.out.println("-->>> validando "+userSecurity.get() + " passwortd "+passwordSecurity.get());
//            userAutentification = JmoordbUtil.desencriptar(userSecurity.get(), "denver16");
//            passwordAutentification = JmoordbUtil.desencriptar(passwordSecurity.get(),"denver16");
            userAutentification = userSecurity;
            passwordAutentification =passwordSecurity;
            System.out.println("-->desencriptado "+userAutentification + " : "+ passwordAutentification);

            if (usernamePasswordCredential.compareTo(userAutentification, passwordAutentification)) {
                System.out.println("----> credencial valida");
                return new CredentialValidationResult(userAutentification, new HashSet<>(asList("admin", "testing")));
            }
        } catch (Exception e) {
            System.out.println("CredentialValidationResult " + e.getLocalizedMessage());
        }

        return INVALID_RESULT;
    }

}
