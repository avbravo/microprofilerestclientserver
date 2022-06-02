/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclienservert.model;

import com.avbravo.jmoordb.anotations.Id;
import com.avbravo.jmoordb.anotations.Secondary;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 *
 * @author avbravo
 */
public class Role {

    @Id
    private Integer idrole;
    @Secondary
    private String role;
    private Boolean active;



    public Role() {
    }

    public Role(Integer idrole, String role, Boolean active) {
        this.idrole = idrole;
        this.role = role;
        this.active = active;
    }

   
    
    
   
  

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

   

     @Override
    public boolean equals(Object object) {
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
         return true;
    }
     
    public boolean equalsReflection(Object object) {
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
         return EqualsBuilder.reflectionEquals(this, object);
    }

   

}
