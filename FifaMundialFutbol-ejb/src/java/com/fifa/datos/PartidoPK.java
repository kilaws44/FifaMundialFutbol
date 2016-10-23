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
public class PartidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idPartido")
    private int idPartido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Equipo_idEquipoB")
    private int equipoidEquipoB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Equipo_idEquipoA")
    private int equipoidEquipoA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mundial_idMundial")
    private int mundialidMundial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ronda_idRonda")
    private int rondaidRonda;

    public PartidoPK() {
    }

    public PartidoPK(int idPartido, int equipoidEquipoB, int equipoidEquipoA, int mundialidMundial, int rondaidRonda) {
        this.idPartido = idPartido;
        this.equipoidEquipoB = equipoidEquipoB;
        this.equipoidEquipoA = equipoidEquipoA;
        this.mundialidMundial = mundialidMundial;
        this.rondaidRonda = rondaidRonda;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getEquipoidEquipoB() {
        return equipoidEquipoB;
    }

    public void setEquipoidEquipoB(int equipoidEquipoB) {
        this.equipoidEquipoB = equipoidEquipoB;
    }

    public int getEquipoidEquipoA() {
        return equipoidEquipoA;
    }

    public void setEquipoidEquipoA(int equipoidEquipoA) {
        this.equipoidEquipoA = equipoidEquipoA;
    }

    public int getMundialidMundial() {
        return mundialidMundial;
    }

    public void setMundialidMundial(int mundialidMundial) {
        this.mundialidMundial = mundialidMundial;
    }

    public int getRondaidRonda() {
        return rondaidRonda;
    }

    public void setRondaidRonda(int rondaidRonda) {
        this.rondaidRonda = rondaidRonda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPartido;
        hash += (int) equipoidEquipoB;
        hash += (int) equipoidEquipoA;
        hash += (int) mundialidMundial;
        hash += (int) rondaidRonda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartidoPK)) {
            return false;
        }
        PartidoPK other = (PartidoPK) object;
        if (this.idPartido != other.idPartido) {
            return false;
        }
        if (this.equipoidEquipoB != other.equipoidEquipoB) {
            return false;
        }
        if (this.equipoidEquipoA != other.equipoidEquipoA) {
            return false;
        }
        if (this.mundialidMundial != other.mundialidMundial) {
            return false;
        }
        if (this.rondaidRonda != other.rondaidRonda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fifa.datos.PartidoPK[ idPartido=" + idPartido + ", equipoidEquipoB=" + equipoidEquipoB + ", equipoidEquipoA=" + equipoidEquipoA + ", mundialidMundial=" + mundialidMundial + ", rondaidRonda=" + rondaidRonda + " ]";
    }
    
}
