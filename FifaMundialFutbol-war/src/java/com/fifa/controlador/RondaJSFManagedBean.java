/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.controlador;

import com.fifa.datos.Ronda;
import com.fifa.negocio.RondaSessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author nicol
 */
@Named(value = "rondaJSFManagedBean")
@SessionScoped
public class RondaJSFManagedBean implements Serializable {

    @EJB
    private RondaSessionBean rondaSessionBean;

    private List<Ronda> ronda;
    private boolean editar = false;
    private int idRonda = -1;
    private String nombre;
   

    /**
     * Creates a new instance of AlumnoBean
     */
    public RondaJSFManagedBean() {
    }
public String eliminar(int idAlumno) {
        this.rondaSessionBean.borrarRonda(idRonda);
        this.ronda = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ronda eliminada con exito", ""));
        return null;
    }

    public String verEditar(boolean ver, int idAlumno, String nombre, String apellido, String legajo) {
        this.editar = ver;
        this.idRonda = idAlumno;
        this.nombre = nombre;
        
        return null;
    }

    public String guardarAlumno() {
        if (this.idRonda == -1) {
            this.rondaSessionBean.agregarRonda(nombre);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ronda agregada con exito", ""));
        } else {
            this.rondaSessionBean.modificarRonda(idRonda, nombre);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ronda modificada con exito", ""));
        }
        this.editar = false;
        this.ronda = null;
        return null;
    }

    
}
