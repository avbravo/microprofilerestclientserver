/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclientserver.services;

import com.avbravo.jmoordb.util.JmoordbUtil;
import com.avbravo.jmoordbutils.JsfUtil;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
//@Stateless
@Named
@ApplicationScoped
public class LoggerServices implements Serializable {
 // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    //otp
    @Inject
    @ConfigProperty(name = "userSecurity", defaultValue = "")
    private Provider<String> userSecurity;
    @Inject
    @ConfigProperty(name = "passwordSecurity", defaultValue = "")
    private Provider<String> passwordSecurity;

    //#--Path Images
    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHomeLogger", defaultValue = "true")
    private Provider<Boolean> pathBaseLinuxAddUserHomeLogger;

    @Inject
    @ConfigProperty(name = "pathLinuxLogger", defaultValue = " ")
    private Provider<String> pathLinuxLogger;
    @Inject
    @ConfigProperty(name = "pathWindowsLogger", defaultValue = " ")
    private Provider<String> pathWindowsLogger;
     @Inject
    @ConfigProperty(name="idrolejefedepartamemto", defaultValue="0")
    private Integer idrolejefedepartamemto;
 // </editor-fold>
    // Add business logic below. (Right-click in editor and choose
    
     // <editor-fold defaultstate="collapsed" desc="String pathLogger()">
/**
 * Devuelve el path del archivo loegger
 * @return 
 */
     public String pathLogger(){
         String path="";
         try {
          path=   (JsfUtil.isLinux()
                    ? (pathBaseLinuxAddUserHomeLogger.get() ? JsfUtil.userHome() + pathLinuxLogger.get() : pathLinuxLogger.get())
                    : pathWindowsLogger.get())+"looger.json";
          
            String   directoryLogger = (JmoordbUtil.isLinux()
                    ? (pathBaseLinuxAddUserHomeLogger.get() ? JmoordbUtil.userHome() + pathLinuxLogger.get() : pathLinuxLogger.get())
                    : pathWindowsLogger.get());
          Path search =Paths.get(directoryLogger);
            if(!Files.exists(search)){
                  File directorio = new File( directoryLogger);
                 if(directorio.mkdirs()){
          //           System.out.println("--------[Creado exitosamente]------");
                 }else{
            //          System.out.println("--------[No se creo el directorio]------");
                 }
            }
         } catch (Exception e) {
             System.out.println("pathLogger() "+e.getLocalizedMessage());
         }
         return path;
     }
     // </editor-fold>
     
        // <editor-fold defaultstate="collapsed" desc=" private void processException(String nameOfClass, String nameOfMethod,  Exception e, Boolean showDialog)">
   public Exception processException(String nameOfClass, String nameOfMethod,  Exception e, Boolean showConsole){
       Exception exception = new Exception(nameOfMethod + " " + e.getLocalizedMessage());
              JmoordbUtil.appendTextToLogErrorFile(pathLogger(), nameOfClass, nameOfMethod, e.getLocalizedMessage(), e);
            
             if(showConsole){
                System.out.println(nameOfClass +"."+nameOfMethod+ " error() "+e.getLocalizedMessage());
             }
         return exception;      
    }
    
// </editor-fold>
}
