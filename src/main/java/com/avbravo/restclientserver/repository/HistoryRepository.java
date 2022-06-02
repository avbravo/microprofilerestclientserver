/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclientserver.repository;

import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.avbravo.restclienservert.model.History;
import javax.ejb.Stateless;

/**
 *
 * @author avbravo
 */
@Stateless
public class HistoryRepository extends Repository<History>{
   public HistoryRepository(){
        super(History.class,"autentification_history","history");
    }  
}
