/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.repository;

import com.avbravo.restclient.domains.Country;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author avbravo
 */
@Stateless
public class CountryRepository {

    List<Country> countrList = new ArrayList<>();

    // <editor-fold defaultstate="collapsed" desc="init">
    private void init() {
        countrList = Arrays.asList(new Country("pa", "Panama"), new Country("es", "España"),
                new Country("mx", "Mexico"), new Country("cu", "Cuba"),
                new Country("co", "Colombia"), new Country("br", "Brasil"),
                new Country("ve","Venezuela"), new Country("tq","Turquia")
        );
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="findAll()">
    public List<Country> findAll() {
        if (countrList.isEmpty()) {
            init();
        }
        return countrList;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="first">
    public Country first() {
        
        return countrList.get(0);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean save(Country country)">
    public Boolean save(Country country) {
        try {
            countrList.add(country);
            return true;
        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }
        return false;

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Country country)">
    public Boolean delete(Country country) {
        try {
            countrList.remove(country);
            return true;
        } catch (Exception e) {
            System.out.println("delete() " + e.getLocalizedMessage());
        }
        return false;

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean dupdate(Country country)">
    public Boolean update(Country country) {
        try {
            Integer index=0;
            for(Country c:countrList){
                if(c.getId().equals(country.getId())){
                    countrList.get(index).setName(country.getName());
                }
                index++;
            }
            countrList.remove(country);
            return true;
        } catch (Exception e) {
            System.out.println("update() " + e.getLocalizedMessage());
        }
        return false;

    }
// </editor-fold>
}
