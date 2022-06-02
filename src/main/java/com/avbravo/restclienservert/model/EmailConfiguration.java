/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclienservert.model;

import com.avbravo.jmoordb.anotations.Id;
import com.avbravo.jmoordb.anotations.Referenced;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 *
 * @author avbravo
 */
public class EmailConfiguration {

    @Id
    private Integer idEmailConfiguration;
    private String email;
    private String password;
    private String mailSmtpHost;
    private String mailSmtpAuth;
    private String mailSmtpPort;
    private String mailSmtpStarttlsEnable;
    @Referenced(collection = "Applicative",
            field = "idapplicative", javatype = "Integer", lazy = false,
            repository = "com.avbravo.restclientserver.repository.ApplicativeRepository")
    private Applicative applicative;
    private Boolean active;

    public EmailConfiguration() {
    }

    public EmailConfiguration(Integer idEmailConfiguration, String email, String password, String mailSmtpHost, String mailSmtpAuth, String mailSmtpPort, String mailSmtpStarttlsEnable, Applicative applicative, Boolean active) {
        this.idEmailConfiguration = idEmailConfiguration;
        this.email = email;
        this.password = password;
        this.mailSmtpHost = mailSmtpHost;
        this.mailSmtpAuth = mailSmtpAuth;
        this.mailSmtpPort = mailSmtpPort;
        this.mailSmtpStarttlsEnable = mailSmtpStarttlsEnable;
        this.applicative = applicative;
        this.active = active;
    }

    
    
    
    public Applicative getApplicative() {
        return applicative;
    }

    public void setApplicative(Applicative applicative) {
        this.applicative = applicative;
    }

   
   

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getIdEmailConfiguration() {
        return idEmailConfiguration;
    }

    public void setIdEmailConfiguration(Integer idEmailConfiguration) {
        this.idEmailConfiguration = idEmailConfiguration;
    }

    


    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailSmtpHost() {
        return mailSmtpHost;
    }

    public void setMailSmtpHost(String mailSmtpHost) {
        this.mailSmtpHost = mailSmtpHost;
    }

    public String getMailSmtpAuth() {
        return mailSmtpAuth;
    }

    public void setMailSmtpAuth(String mailSmtpAuth) {
        this.mailSmtpAuth = mailSmtpAuth;
    }

    public String getMailSmtpPort() {
        return mailSmtpPort;
    }

    public void setMailSmtpPort(String mailSmtpPort) {
        this.mailSmtpPort = mailSmtpPort;
    }

    public String getMailSmtpStarttlsEnable() {
        return mailSmtpStarttlsEnable;
    }

    public void setMailSmtpStarttlsEnable(String mailSmtpStarttlsEnable) {
        this.mailSmtpStarttlsEnable = mailSmtpStarttlsEnable;
    }

   
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmailConfiguration)) {
            return false;
        }
      EmailConfiguration other = (EmailConfiguration) object;
        if ((this.email== null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
     return true;
    }

    public boolean equalsReflection(Object object) {
        if (!(object instanceof EmailConfiguration)) {
            return false;
        }
      EmailConfiguration other = (EmailConfiguration) object;
        if ((this.email== null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
     return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return "EmailConfiguration{" + "idEmailConfiguration=" + idEmailConfiguration + ", email=" + email + ", password=" + password + ", mailSmtpHost=" + mailSmtpHost + ", mailSmtpAuth=" + mailSmtpAuth + ", mailSmtpPort=" + mailSmtpPort + ", mailSmtpStarttlsEnable=" + mailSmtpStarttlsEnable + ", applicative=" + applicative + ", active=" + active + '}';
    }
    
    
    
    
}
