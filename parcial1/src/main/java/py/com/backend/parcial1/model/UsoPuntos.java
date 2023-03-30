/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author macro
 */
@Entity
@Table(name = "uso_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsoPuntos.findAll", query = "SELECT u FROM UsoPuntos u")
    , @NamedQuery(name = "UsoPuntos.findById", query = "SELECT u FROM UsoPuntos u WHERE u.id = :id")
    , @NamedQuery(name = "UsoPuntos.findByPuntajeUtilizado", query = "SELECT u FROM UsoPuntos u WHERE u.puntajeUtilizado = :puntajeUtilizado")
    , @NamedQuery(name = "UsoPuntos.findByFecha", query = "SELECT u FROM UsoPuntos u WHERE u.fecha = :fecha")})
public class UsoPuntos implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usoPuntosId")
    private List<DetalleUsoPuntos> detalleUsoPuntosList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "concepto_uso_punto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConceptosUsoPuntos conceptoUsoPuntoId;

    public UsoPuntos() {
    }

    public UsoPuntos(Integer id) {
        this.id = id;
    }

    public UsoPuntos(Integer id, int puntajeUtilizado, Date fecha) {
        this.id = id;
        this.puntajeUtilizado = puntajeUtilizado;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<DetalleUsoPuntos> getDetalleUsoPuntosList() {
        return detalleUsoPuntosList;
    }

    public void setDetalleUsoPuntosList(List<DetalleUsoPuntos> detalleUsoPuntosList) {
        this.detalleUsoPuntosList = detalleUsoPuntosList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ConceptosUsoPuntos getConceptoUsoPuntoId() {
        return conceptoUsoPuntoId;
    }

    public void setConceptoUsoPuntoId(ConceptosUsoPuntos conceptoUsoPuntoId) {
        this.conceptoUsoPuntoId = conceptoUsoPuntoId;
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
        if (!(object instanceof UsoPuntos)) {
            return false;
        }
        UsoPuntos other = (UsoPuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.backend.parcial1.model.UsoPuntos[ id=" + id + " ]";
    }
    
}
