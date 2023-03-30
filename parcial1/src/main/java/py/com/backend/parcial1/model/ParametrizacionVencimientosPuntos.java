/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macro
 */
@Entity
@Table(name = "parametrizacion_vencimientos_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametrizacionVencimientosPuntos.findAll", query = "SELECT p FROM ParametrizacionVencimientosPuntos p")
    , @NamedQuery(name = "ParametrizacionVencimientosPuntos.findById", query = "SELECT p FROM ParametrizacionVencimientosPuntos p WHERE p.id = :id")
    , @NamedQuery(name = "ParametrizacionVencimientosPuntos.findByFechaInicioValidez", query = "SELECT p FROM ParametrizacionVencimientosPuntos p WHERE p.fechaInicioValidez = :fechaInicioValidez")
    , @NamedQuery(name = "ParametrizacionVencimientosPuntos.findByFechaFinValidez", query = "SELECT p FROM ParametrizacionVencimientosPuntos p WHERE p.fechaFinValidez = :fechaFinValidez")
    , @NamedQuery(name = "ParametrizacionVencimientosPuntos.findByDiasDuracionPuntaje", query = "SELECT p FROM ParametrizacionVencimientosPuntos p WHERE p.diasDuracionPuntaje = :diasDuracionPuntaje")})
public class ParametrizacionVencimientosPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_validez")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioValidez;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_validez")
    @Temporal(TemporalType.DATE)
    private Date fechaFinValidez;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_duracion_puntaje")
    private int diasDuracionPuntaje;

    public ParametrizacionVencimientosPuntos() {
    }

    public ParametrizacionVencimientosPuntos(Integer id) {
        this.id = id;
    }

    public ParametrizacionVencimientosPuntos(Integer id, Date fechaInicioValidez, Date fechaFinValidez, int diasDuracionPuntaje) {
        this.id = id;
        this.fechaInicioValidez = fechaInicioValidez;
        this.fechaFinValidez = fechaFinValidez;
        this.diasDuracionPuntaje = diasDuracionPuntaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicioValidez() {
        return fechaInicioValidez;
    }

    public void setFechaInicioValidez(Date fechaInicioValidez) {
        this.fechaInicioValidez = fechaInicioValidez;
    }

    public Date getFechaFinValidez() {
        return fechaFinValidez;
    }

    public void setFechaFinValidez(Date fechaFinValidez) {
        this.fechaFinValidez = fechaFinValidez;
    }

    public int getDiasDuracionPuntaje() {
        return diasDuracionPuntaje;
    }

    public void setDiasDuracionPuntaje(int diasDuracionPuntaje) {
        this.diasDuracionPuntaje = diasDuracionPuntaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrizacionVencimientosPuntos)) {
            return false;
        }
        ParametrizacionVencimientosPuntos other = (ParametrizacionVencimientosPuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.backend.parcial1.model.ParametrizacionVencimientosPuntos[ id=" + id + " ]";
    }
    
}
