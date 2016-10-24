/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.controlador;

import com.fifa.datos.Zona;
import com.fifa.negocio.ZonaSessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author pepeteban
 */
@Named(value = "zonaJSFManagedBean")
@SessionScoped
public class ZonaJSFManagedBean implements Serializable {

    @EJB
    private ZonaSessionBean zonaSessionBean;

    private List<Zona> zona;
    private boolean editar = false;
    private int idZona = -1;
    private char nombre;
   

    /**
     * Creates a new instance of AlumnoBean
     */
    
 public String eliminar(int idZona) {
        this.zonaSessionBean.borrarZona(idZona);
        this.zona = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zona eliminada con exito", ""));
        return null;
    }
    

    public String verEditar(boolean ver, int idZona, char nombre) {
        this.editar = ver;
        this.idZona = idZona;
        this.nombre = nombre;
        
        return null;
    }

    public String guardarZona() {
        if (this.idZona == -1) {
            this.zonaSessionBean.agregarZona(nombre);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zona agregada con exito", ""));
        } else {
            this.zonaSessionBean.modificarZona(idZona, nombre);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zona modificada con exito", ""));
        }
        this.editar = false;
        this.zona = null;
        return null;
    }
    
    
    /**
     * Creates a new instance of ZonaJSFManagedBean
     */
    public ZonaJSFManagedBean() {
    }
    
}
