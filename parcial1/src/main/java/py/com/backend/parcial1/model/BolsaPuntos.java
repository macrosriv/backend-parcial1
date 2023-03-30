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
@Table(name = "bolsa_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BolsaPuntos.findAll", query = "SELECT b FROM BolsaPuntos b")
    , @NamedQuery(name = "BolsaPuntos.findById", query = "SELECT b FROM BolsaPuntos b WHERE b.id = :id")
    , @NamedQuery(name = "BolsaPuntos.findByFechaAsignacionPuntaje", query = "SELECT b FROM BolsaPuntos b WHERE b.fechaAsignacionPuntaje = :fechaAsignacionPuntaje")
    , @NamedQuery(name = "BolsaPuntos.findByFechaCaducidadPuntaje", query = "SELECT b FROM BolsaPuntos b WHERE b.fechaCaducidadPuntaje = :fechaCaducidadPuntaje")
    , @NamedQuery(name = "BolsaPuntos.findByPuntajeAsignado", query = "SELECT b FROM BolsaPuntos b WHERE b.puntajeAsignado = :puntajeAsignado")
    , @NamedQuery(name = "BolsaPuntos.findByPuntajeUtilizado", query = "SELECT b FROM BolsaPuntos b WHERE b.puntajeUtilizado = :puntajeUtilizado")
    , @NamedQuery(name = "BolsaPuntos.findBySaldoPuntos", query = "SELECT b FROM BolsaPuntos b WHERE b.saldoPuntos = :saldoPuntos")
    , @NamedQuery(name = "BolsaPuntos.findByMontoOperacion", query = "SELECT b FROM BolsaPuntos b WHERE b.montoOperacion = :montoOperacion")})
public class BolsaPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion_puntaje")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionPuntaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_caducidad_puntaje")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidadPuntaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_asignado")
    private int puntajeAsignado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje_utilizado")
    private int puntajeUtilizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_puntos")
    private int saldoPuntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_operacion")
    private int montoOperacion;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bolsaPuntosId")
    private List<DetalleUsoPuntos> detalleUsoPuntosList;

    public BolsaPuntos() {
    }

    public BolsaPuntos(Integer id) {
        this.id = id;
    }

    public BolsaPuntos(Integer id, Date fechaAsignacionPuntaje, Date fechaCaducidadPuntaje, int puntajeAsignado, int puntajeUtilizado, int saldoPuntos, int montoOperacion) {
        this.id = id;
        this.fechaAsignacionPuntaje = fechaAsignacionPuntaje;
        this.fechaCaducidadPuntaje = fechaCaducidadPuntaje;
        this.puntajeAsignado = puntajeAsignado;
        this.puntajeUtilizado = puntajeUtilizado;
        this.saldoPuntos = saldoPuntos;
        this.montoOperacion = montoOperacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaAsignacionPuntaje() {
        return fechaAsignacionPuntaje;
    }

    public void setFechaAsignacionPuntaje(Date fechaAsignacionPuntaje) {
        this.fechaAsignacionPuntaje = fechaAsignacionPuntaje;
    }

    public Date getFechaCaducidadPuntaje() {
        return fechaCaducidadPuntaje;
    }

    public void setFechaCaducidadPuntaje(Date fechaCaducidadPuntaje) {
        this.fechaCaducidadPuntaje = fechaCaducidadPuntaje;
    }

    public int getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(int puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public int getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(int saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public int getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(int montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public List<DetalleUsoPuntos> getDetalleUsoPuntosList() {
        return detalleUsoPuntosList;
    }

    public void setDetalleUsoPuntosList(List<DetalleUsoPuntos> detalleUsoPuntosList) {
        this.detalleUsoPuntosList = detalleUsoPuntosList;
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
        if (!(object instanceof BolsaPuntos)) {
            return false;
        }
        BolsaPuntos other = (BolsaPuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.backend.parcial1.model.BolsaPuntos[ id=" + id + " ]";
    }
    
}
