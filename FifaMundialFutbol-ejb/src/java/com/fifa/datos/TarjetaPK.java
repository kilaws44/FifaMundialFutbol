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
public class TarjetaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTarjeta")
    private int idTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JugadoresXPartido_idJugadorXpartido")
    private int jugadoresXPartidoidJugadorXpartido;

    public TarjetaPK() {
    }

    public TarjetaPK(int idTarjeta, int jugadoresXPartidoidJugadorXpartido) {
        this.idTarjeta = idTarjeta;
        this.jugadoresXPartidoidJugadorXpartido = jugadoresXPartidoidJugadorXpartido;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getJugadoresXPartidoidJugadorXpartido() {
        return jugadoresXPartidoidJugadorXpartido;
    }

    public void setJugadoresXPartidoidJugadorXpartido(int jugadoresXPartidoidJugadorXpartido) {
        this.jugadoresXPartidoidJugadorXpartido = jugadoresXPartidoidJugadorXpartido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTarjeta;
        hash += (int) jugadoresXPartidoidJugadorXpartido;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaPK)) {
            return false;
        }
        TarjetaPK other = (TarjetaPK) object;
        if (this.idTarjeta != other.idTarjeta) {
            return false;
        }
        if (this.jugadoresXPartidoidJugadorXpartido != other.jugadoresXPartidoidJugadorXpartido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fifa.datos.TarjetaPK[ idTarjeta=" + idTarjeta + ", jugadoresXPartidoidJugadorXpartido=" + jugadoresXPartidoidJugadorXpartido + " ]";
    }
    
}
