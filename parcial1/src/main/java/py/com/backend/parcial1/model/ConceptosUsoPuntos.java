/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author macro
 */
@Entity
@Table(name = "conceptos_uso_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptosUsoPuntos.findAll", query = "SELECT c FROM ConceptosUsoPuntos c")
    , @NamedQuery(name = "ConceptosUsoPuntos.findById", query = "SELECT c FROM ConceptosUsoPuntos c WHERE c.id = :id")
    , @NamedQuery(name = "ConceptosUsoPuntos.findByDescripcion", query = "SELECT c FROM ConceptosUsoPuntos c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "ConceptosUsoPuntos.findByPuntosRequeridos", query = "SELECT c FROM ConceptosUsoPuntos c WHERE c.puntosRequeridos = :puntosRequeridos")})
public class ConceptosUsoPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos_requeridos")
    private int puntosRequeridos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conceptoUsoPuntoId")
    private List<UsoPuntos> usoPuntosList;

    public ConceptosUsoPuntos() {
    }

    public ConceptosUsoPuntos(Integer id) {
        this.id = id;
    }

    public ConceptosUsoPuntos(Integer id, String descripcion, int puntosRequeridos) {
        this.id = id;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(int puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    @XmlTransient
    public List<UsoPuntos> getUsoPuntosList() {
        return usoPuntosList;
    }

    public void setUsoPuntosList(List<UsoPuntos> usoPuntosList) {
        this.usoPuntosList = usoPuntosList;
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
        if (!(object instanceof ConceptosUsoPuntos)) {
            return false;
        }
        ConceptosUsoPuntos other = (ConceptosUsoPuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.backend.parcial1.model.ConceptosUsoPuntos[ id=" + id + " ]";
    }
    
}
