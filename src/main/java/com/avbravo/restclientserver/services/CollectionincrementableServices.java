/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclientserver.services;


import com.avbravo.restclienservert.model.Collectionincrementable;
import com.avbravo.restclientserver.repository.CollectionincrementableRepository;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@Stateless
public class CollectionincrementableServices {
    
    
 @Inject
   CollectionincrementableRepository collectionincrementableRepository; 
// String directoryLogger = JmoordbUtil.isLinux() ? JmoordbUtil.userHome() + JmoordbUtil.fileSeparator() + "autentificacion" + JmoordbUtil.fileSeparator() + "logs" + JmoordbUtil.fileSeparator() + "logger.json" : "C:\\autentificacion\\logs\\logger.json";
    /**
     * Creates a new instance of CollectionincrementableServices
     */
    public CollectionincrementableServices() {
    }
        // <editor-fold defaultstate="collapsed" desc="Collectionincrementable generaten(String collection)">

    public Collectionincrementable generate(String collection) {
        Collectionincrementable collectionincrementable = new Collectionincrementable(collection, 0);;

        try {
            Optional<Collectionincrementable> collectionincrementableOptional = collectionincrementableRepository.find(new Document("collection", collection));
            if (!collectionincrementableOptional.isPresent()) {

                collectionincrementable = new Collectionincrementable(collection, 0);
                if (collectionincrementableRepository.save(collectionincrementable)) {
                }
            }
            
         collectionincrementable = new Collectionincrementable();
            collectionincrementable = collectionincrementableRepository.findOneAndUpdate("collections", collection, "count");



        } catch (Exception e) {

//            JmoordbUtil.appendTextToLogErrorFile(this.directoryLogger, JmoordbUtil.nameOfClass(), JmoordbUtil.nameOfMethod(), e.getLocalizedMessage(), e);
        }

        return collectionincrementable;
    }
// </editor-fold>
}
