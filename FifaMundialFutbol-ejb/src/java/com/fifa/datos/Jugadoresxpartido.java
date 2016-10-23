/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.datos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "jugadoresxpartido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugadoresxpartido.findAll", query = "SELECT j FROM Jugadoresxpartido j"),
    @NamedQuery(name = "Jugadoresxpartido.findByIdJugadorXpartido", query = "SELECT j FROM Jugadoresxpartido j WHERE j.jugadoresxpartidoPK.idJugadorXpartido = :idJugadorXpartido"),
    @NamedQuery(name = "Jugadoresxpartido.findByPartidoidPartido", query = "SELECT j FROM Jugadoresxpartido j WHERE j.jugadoresxpartidoPK.partidoidPartido = :partidoidPartido"),
    @NamedQuery(name = "Jugadoresxpartido.findByJugadoridJugador", query = "SELECT j FROM Jugadoresxpartido j WHERE j.jugadoresxpartidoPK.jugadoridJugador = :jugadoridJugador"),
    @NamedQuery(name = "Jugadoresxpartido.findByTitular", query = "SELECT j FROM Jugadoresxpartido j WHERE j.titular = :titular"),
    @NamedQuery(name = "Jugadoresxpartido.findBySuplente", query = "SELECT j FROM Jugadoresxpartido j WHERE j.suplente = :suplente")})
public class Jugadoresxpartido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JugadoresxpartidoPK jugadoresxpartidoPK;
    @Column(name = "titular")
    private Boolean titular;
    @Column(name = "suplente")
    private Boolean suplente;
    @JoinColumn(name = "Equipo_idEquipo", referencedColumnName = "idEquipo")
    @ManyToOne(optional = false)
    private Equipo equipoidEquipo;
    @JoinColumn(name = "Jugador_idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador;
    @JoinColumn(name = "Partido_idPartido", referencedColumnName = "idPartido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partido partido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugadoresxpartido")
    private Collection<Tarjeta> tarjetaCollection;

    public Jugadoresxpartido() {
    }

    public Jugadoresxpartido(JugadoresxpartidoPK jugadoresxpartidoPK) {
        this.jugadoresxpartidoPK = jugadoresxpartidoPK;
    }

    public Jugadoresxpartido(int idJugadorXpartido, int partidoidPartido, int jugadoridJugador) {
        this.jugadoresxpartidoPK = new JugadoresxpartidoPK(idJugadorXpartido, partidoidPartido, jugadoridJugador);
    }

    public JugadoresxpartidoPK getJugadoresxpartidoPK() {
        return jugadoresxpartidoPK;
    }

    public void setJugadoresxpartidoPK(JugadoresxpartidoPK jugadoresxpartidoPK) {
        this.jugadoresxpartidoPK = jugadoresxpartidoPK;
    }

    public Boolean getTitular() {
        return titular;
    }

    public void setTitular(Boolean titular) {
        this.titular = titular;
    }

    public Boolean getSuplente() {
        return suplente;
    }

    public void setSuplente(Boolean suplente) {
        this.suplente = suplente;
    }

    public Equipo getEquipoidEquipo() {
        return equipoidEquipo;
    }

    public void setEquipoidEquipo(Equipo equipoidEquipo) {
        this.equipoidEquipo = equipoidEquipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @XmlTransient
    public Collection<Tarjeta> getTarjetaCollection() {
        return tarjetaCollection;
    }

    public void setTarjetaCollection(Collection<Tarjeta> tarjetaCollection) {
        this.tarjetaCollection = tarjetaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadoresxpartidoPK != null ? jugadoresxpartidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadoresxpartido)) {
            return false;
        }
        Jugadoresxpartido other = (Jugadoresxpartido) object;
        if ((this.jugadoresxpartidoPK == null && other.jugadoresxpartidoPK != null) || (this.jugadoresxpartidoPK != null && !this.jugadoresxpartidoPK.equals(other.jugadoresxpartidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fifa.datos.Jugadoresxpartido[ jugadoresxpartidoPK=" + jugadoresxpartidoPK + " ]";
    }
    
}
