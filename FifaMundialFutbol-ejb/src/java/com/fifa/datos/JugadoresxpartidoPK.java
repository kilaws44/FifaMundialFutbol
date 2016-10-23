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
public class JugadoresxpartidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idJugadorXpartido")
    private int idJugadorXpartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Partido_idPartido")
    private int partidoidPartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Jugador_idJugador")
    private int jugadoridJugador;

    public JugadoresxpartidoPK() {
    }

    public JugadoresxpartidoPK(int idJugadorXpartido, int partidoidPartido, int jugadoridJugador) {
        this.idJugadorXpartido = idJugadorXpartido;
        this.partidoidPartido = partidoidPartido;
        this.jugadoridJugador = jugadoridJugador;
    }

    public int getIdJugadorXpartido() {
        return idJugadorXpartido;
    }

    public void setIdJugadorXpartido(int idJugadorXpartido) {
        this.idJugadorXpartido = idJugadorXpartido;
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
        hash += (int) idJugadorXpartido;
        hash += (int) partidoidPartido;
        hash += (int) jugadoridJugador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadoresxpartidoPK)) {
            return false;
        }
        JugadoresxpartidoPK other = (JugadoresxpartidoPK) object;
        if (this.idJugadorXpartido != other.idJugadorXpartido) {
            return false;
        }
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
        return "com.fifa.datos.JugadoresxpartidoPK[ idJugadorXpartido=" + idJugadorXpartido + ", partidoidPartido=" + partidoidPartido + ", jugadoridJugador=" + jugadoridJugador + " ]";
    }
    
}
