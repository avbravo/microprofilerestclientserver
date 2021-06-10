/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.entity;

import com.avbravo.jmoordb.anotations.Id;



/**
 *
 * @author avbravo
 */
public class Country {
    @Id
    private String id;
    private String name;

    public Country() {
    }

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
    
    
   public static class Builder{
        private String id;
    private String name;
    
    public Builder id(String id){
        this.id = id;
        return this;
    }
    public Builder name(String name){
        this.name= name;
        return this;
    }
    
    public Country build(){
        return new Country(id, name);
    }
   }
    
}
