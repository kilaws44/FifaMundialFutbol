/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.negocio;

import com.fifa.datos.Ronda;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicol
 */
@Stateless
@LocalBean
public class RondaSessionBean {

    @PersistenceContext(unitName = "FifaMundialFutbol-ejbPU")
    private EntityManager em;
   public List<Ronda> obtenerRonda() {
        try {
            javax.persistence.Query q= em.createNamedQuery("Ronda.findAll");
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public Ronda obtenerRonda(int idRonda) {
        try {
            em.getEntityManagerFactory().getCache().evict(Ronda.class);
            Ronda r = em.find(Ronda.class, idRonda);
            return r;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean borrarRonda(int idRonda) {
        try {
            em.getEntityManagerFactory().getCache().evict(Ronda.class);
            Ronda r = em.find(Ronda.class, idRonda);
            em.remove(r);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean agregarRonda(String nombre) {
        try {
            Ronda r = new Ronda();
          r.setNombre(nombre);
             em.persist(r);
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean modificarRonda(int idRonda, String nombre) {
        try {
            Ronda r = em.find(Ronda.class, idRonda);
            r.setNombre(nombre);
          r.setIdRonda(0);
            em.merge(r);
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
