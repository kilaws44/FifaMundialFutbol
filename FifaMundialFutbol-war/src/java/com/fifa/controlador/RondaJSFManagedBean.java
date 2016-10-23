/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.controlador;

import com.fifa.negocio.RondaSessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author nicol
 */
@Named(value = "rondaJSFManagedBean")
@SessionScoped
public class RondaJSFManagedBean implements Serializable {

    @EJB
    private RondaSessionBean rondaSessionBean;

    /**
     * Creates a new instance of RondaJSFManagedBean
     */
    public RondaJSFManagedBean() {
    }
    
}
