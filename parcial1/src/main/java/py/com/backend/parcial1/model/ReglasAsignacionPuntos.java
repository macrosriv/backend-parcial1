/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macro
 */
@Entity
@Table(name = "reglas_asignacion_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReglasAsignacionPuntos.findAll", query = "SELECT r FROM ReglasAsignacionPuntos r")
    , @NamedQuery(name = "ReglasAsignacionPuntos.findById", query = "SELECT r FROM ReglasAsignacionPuntos r WHERE r.id = :id")
    , @NamedQuery(name = "ReglasAsignacionPuntos.findByLimiteInferior", query = "SELECT r FROM ReglasAsignacionPuntos r WHERE r.limiteInferior = :limiteInferior")
    , @NamedQuery(name = "ReglasAsignacionPuntos.findByLimiteSuperior", query = "SELECT r FROM ReglasAsignacionPuntos r WHERE r.limiteSuperior = :limiteSuperior")
    , @NamedQuery(name = "ReglasAsignacionPuntos.findByMontoEquivalencia", query = "SELECT r FROM ReglasAsignacionPuntos r WHERE r.montoEquivalencia = :montoEquivalencia")})
public class ReglasAsignacionPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "limite_inferior")
    private Integer limiteInferior;
    @Column(name = "limite_superior")
    private Integer limiteSuperior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_equivalencia")
    private int montoEquivalencia;

    public ReglasAsignacionPuntos() {
    }

    public ReglasAsignacionPuntos(Integer id) {
        this.id = id;
    }

    public ReglasAsignacionPuntos(Integer id, int montoEquivalencia) {
        this.id = id;
        this.montoEquivalencia = montoEquivalencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public int getMontoEquivalencia() {
        return montoEquivalencia;
    }

    public void setMontoEquivalencia(int montoEquivalencia) {
        this.montoEquivalencia = montoEquivalencia;
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
        if (!(object instanceof ReglasAsignacionPuntos)) {
            return false;
        }
        ReglasAsignacionPuntos other = (ReglasAsignacionPuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.backend.parcial1.model.ReglasAsignacionPuntos[ id=" + id + " ]";
    }
    
}
