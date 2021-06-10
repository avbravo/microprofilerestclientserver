/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.repository;

import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.avbravo.restclient.entity.Country;
import javax.ejb.Stateless;

/**
 *
 * @author avbravo
 */
@Stateless
public class CountryRepository extends Repository<Country> {

  public CountryRepository(){
      super(Country.class,"restclient","country");
  }
}
