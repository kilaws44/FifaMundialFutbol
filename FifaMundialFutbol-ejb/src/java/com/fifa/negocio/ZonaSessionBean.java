/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.negocio;

import com.fifa.datos.Zona;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pepeteban
 */
@Stateless
@LocalBean
public class ZonaSessionBean {

    @PersistenceContext(unitName = "FifaMundialFutbol-ejbPU")
    private EntityManager em;
    
     public List<Zona> obtenerZona() {
        try {
            javax.persistence.Query q= em.createNamedQuery("Zona.findAll");
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public Zona obtenerZona(String nombre) {
        try {
            em.getEntityManagerFactory().getCache().evict(Zona.class);
            Zona z = em.find(Zona.class, nombre);
            return z;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean borrarZona(int idZona) {
        try {
            em.getEntityManagerFactory().getCache().evict(Zona.class);
            Zona z = em.find(Zona.class, idZona);
            em.remove(z);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean agregarZona(char nombre) {
        try {
            Zona z = new Zona();  
            z.setNombre(nombre);
            em.persist(z);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean modificarZona(int idZona, char nombre) {
        try {
            Zona z = em.find(Zona.class, nombre);
            
            z.setNombre(nombre);
          
            em.merge(z);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

    public void persist(Object object) {
        em.persist(object);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
