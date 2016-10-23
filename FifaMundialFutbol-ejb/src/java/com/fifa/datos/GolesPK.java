/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.datos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nicol
 */
@Embeddable
public class GolesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Partido_idPartido")
    private int partidoidPartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Jugador_idJugador")
    private int jugadoridJugador;

    public GolesPK() {
    }

    public GolesPK(int partidoidPartido, int jugadoridJugador) {
        this.partidoidPartido = partidoidPartido;
        this.jugadoridJugador = jugadoridJugador;
    }

    public int getPartidoidPartido() {
        return partidoidPartido;
    }

    public void setPartidoidPartido(int partidoidPartido) {
        this.partidoidPartido = partidoidPartido;
    }

    public int getJugadoridJugador() {
        return jugadoridJugador;
    }

    public void setJugadoridJugador(int jugadoridJugador) {
        this.jugadoridJugador = jugadoridJugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) partidoidPartido;
        hash += (int) jugadoridJugador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GolesPK)) {
            return false;
        }
        GolesPK other = (GolesPK) object;
        if (this.partidoidPartido != other.partidoidPartido) {
            return false;
        }
        if (this.jugadoridJugador != other.jugadoridJugador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fifa.datos.GolesPK[ partidoidPartido=" + partidoidPartido + ", jugadoridJugador=" + jugadoridJugador + " ]";
    }
    
}
