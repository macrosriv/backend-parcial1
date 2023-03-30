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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "detalle_uso_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleUsoPuntos.findAll", query = "SELECT d FROM DetalleUsoPuntos d")
    , @NamedQuery(name = "DetalleUsoPuntos.findById", query = "SELECT d FROM DetalleUsoPuntos d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleUsoPuntos.findByPuntajeUtilizado", query = "SELECT d FROM DetalleUsoPuntos d WHERE d.puntajeUtilizado = :puntajeUtilizado")})
public class DetalleUsoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_utilizado")
    private int puntajeUtilizado;
    @JoinColumn(name = "bolsa_puntos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BolsaPuntos bolsaPuntosId;
    @JoinColumn(name = "uso_puntos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UsoPuntos usoPuntosId;

    public DetalleUsoPuntos() {
    }

    public DetalleUsoPuntos(Integer id) {
        this.id = id;
    }

    public DetalleUsoPuntos(Integer id, int puntajeUtilizado) {
        this.id = id;
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public BolsaPuntos getBolsaPuntosId() {
        return bolsaPuntosId;
    }

    public void setBolsaPuntosId(BolsaPuntos bolsaPuntosId) {
        this.bolsaPuntosId = bolsaPuntosId;
    }

    public UsoPuntos getUsoPuntosId() {
        return usoPuntosId;
    }

    public void setUsoPuntosId(UsoPuntos usoPuntosId) {
        this.usoPuntosId = usoPuntosId;
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
        if (!(object instanceof DetalleUsoPuntos)) {
            return false;
        }
        DetalleUsoPuntos other = (DetalleUsoPuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.backend.parcial1.model.DetalleUsoPuntos[ id=" + id + " ]";
    }
    
}
