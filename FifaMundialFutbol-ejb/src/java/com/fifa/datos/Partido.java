/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fifa.datos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nicol
 */
@Entity
@Table(name = "partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p"),
    @NamedQuery(name = "Partido.findByIdPartido", query = "SELECT p FROM Partido p WHERE p.partidoPK.idPartido = :idPartido"),
    @NamedQuery(name = "Partido.findByFecha", query = "SELECT p FROM Partido p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Partido.findByHora", query = "SELECT p FROM Partido p WHERE p.hora = :hora"),
    @NamedQuery(name = "Partido.findByEquipoidEquipoB", query = "SELECT p FROM Partido p WHERE p.partidoPK.equipoidEquipoB = :equipoidEquipoB"),
    @NamedQuery(name = "Partido.findByEquipoidEquipoA", query = "SELECT p FROM Partido p WHERE p.partidoPK.equipoidEquipoA = :equipoidEquipoA"),
    @NamedQuery(name = "Partido.findByRdoA", query = "SELECT p FROM Partido p WHERE p.rdoA = :rdoA"),
    @NamedQuery(name = "Partido.findByRdoB", query = "SELECT p FROM Partido p WHERE p.rdoB = :rdoB"),
    @NamedQuery(name = "Partido.findByMundialidMundial", query = "SELECT p FROM Partido p WHERE p.partidoPK.mundialidMundial = :mundialidMundial"),
    @NamedQuery(name = "Partido.findByRondaidRonda", query = "SELECT p FROM Partido p WHERE p.partidoPK.rondaidRonda = :rondaidRonda"),
    @NamedQuery(name = "Partido.findByPenalesA", query = "SELECT p FROM Partido p WHERE p.penalesA = :penalesA"),
    @NamedQuery(name = "Partido.findByPenalesB", query = "SELECT p FROM Partido p WHERE p.penalesB = :penalesB")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartidoPK partidoPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "Hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Column(name = "rdoA")
    private Integer rdoA;
    @Column(name = "rdoB")
    private Integer rdoB;
    @Column(name = "penalesA")
    private Integer penalesA;
    @Column(name = "penalesB")
    private Integer penalesB;
    @ManyToMany(mappedBy = "partidoCollection")
    private Collection<Arbitro> arbitroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partido")
    private Collection<Jugadoresxpartido> jugadoresxpartidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partido")
    private Collection<Goles> golesCollection;
    @JoinColumn(name = "Equipo_idEquipoA", referencedColumnName = "idEquipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @JoinColumn(name = "Equipo_idEquipoB", referencedColumnName = "idEquipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo1;
    @JoinColumn(name = "Estadio_idEstadio", referencedColumnName = "idEstadio")
    @ManyToOne
    private Estadio estadioidEstadio;
    @JoinColumn(name = "Jugador_CapitanA", referencedColumnName = "idJugador")
    @ManyToOne
    private Jugador jugadorCapitanA;
    @JoinColumn(name = "Jugador_CapitanB", referencedColumnName = "idJugador")
    @ManyToOne
    private Jugador jugadorCapitanB;
    @JoinColumn(name = "Mundial_idMundial", referencedColumnName = "idMundial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Mundial mundial;
    @JoinColumn(name = "Ronda_idRonda", referencedColumnName = "idRonda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ronda ronda;

    public Partido() {
    }

    public Partido(PartidoPK partidoPK) {
        this.partidoPK = partidoPK;
    }

    public Partido(int idPartido, int equipoidEquipoB, int equipoidEquipoA, int mundialidMundial, int rondaidRonda) {
        this.partidoPK = new PartidoPK(idPartido, equipoidEquipoB, equipoidEquipoA, mundialidMundial, rondaidRonda);
    }

    public PartidoPK getPartidoPK() {
        return partidoPK;
    }

    public void setPartidoPK(PartidoPK partidoPK) {
        this.partidoPK = partidoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Integer getRdoA() {
        return rdoA;
    }

    public void setRdoA(Integer rdoA) {
        this.rdoA = rdoA;
    }

    public Integer getRdoB() {
        return rdoB;
    }

    public void setRdoB(Integer rdoB) {
        this.rdoB = rdoB;
    }

    public Integer getPenalesA() {
        return penalesA;
    }

    public void setPenalesA(Integer penalesA) {
        this.penalesA = penalesA;
    }

    public Integer getPenalesB() {
        return penalesB;
    }

    public void setPenalesB(Integer penalesB) {
        this.penalesB = penalesB;
    }

    @XmlTransient
    public Collection<Arbitro> getArbitroCollection() {
        return arbitroCollection;
    }

    public void setArbitroCollection(Collection<Arbitro> arbitroCollection) {
        this.arbitroCollection = arbitroCollection;
    }

    @XmlTransient
    public Collection<Jugadoresxpartido> getJugadoresxpartidoCollection() {
        return jugadoresxpartidoCollection;
    }

    public void setJugadoresxpartidoCollection(Collection<Jugadoresxpartido> jugadoresxpartidoCollection) {
        this.jugadoresxpartidoCollection = jugadoresxpartidoCollection;
    }

    @XmlTransient
    public Collection<Goles> getGolesCollection() {
        return golesCollection;
    }

    public void setGolesCollection(Collection<Goles> golesCollection) {
        this.golesCollection = golesCollection;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Estadio getEstadioidEstadio() {
        return estadioidEstadio;
    }

    public void setEstadioidEstadio(Estadio estadioidEstadio) {
        this.estadioidEstadio = estadioidEstadio;
    }

    public Jugador getJugadorCapitanA() {
        return jugadorCapitanA;
    }

    public void setJugadorCapitanA(Jugador jugadorCapitanA) {
        this.jugadorCapitanA = jugadorCapitanA;
    }

    public Jugador getJugadorCapitanB() {
        return jugadorCapitanB;
    }

    public void setJugadorCapitanB(Jugador jugadorCapitanB) {
        this.jugadorCapitanB = jugadorCapitanB;
    }

    public Mundial getMundial() {
        return mundial;
    }

    public void setMundial(Mundial mundial) {
        this.mundial = mundial;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partidoPK != null ? partidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.partidoPK == null && other.partidoPK != null) || (this.partidoPK != null && !this.partidoPK.equals(other.partidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fifa.datos.Partido[ partidoPK=" + partidoPK + " ]";
    }
    
}
