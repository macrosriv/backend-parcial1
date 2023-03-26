/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author macro
 */
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "clenteIdSeq", sequenceName = "cliente_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "clenteIdSeq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name = "apellido", length = 100)
    private String apellido;
    @Column(name = "nro_documento", length = 50)
    private String nroDocumento;
    @Column(name = "tipo_documento", length = 10)
    private String tipoDocumento;
    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "telefono", length = 100)
    private String telefono;
    @Column(name = "fecha_nacimiento", length = 100)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id 
                + ", nombre=" + nombre 
                + ", apellido=" + apellido 
                + ", nroDocumento=" + nroDocumento 
                + ", tipoDocumento=" + tipoDocumento 
                + ", nacionalidad=" + nacionalidad 
                + ", email=" + email 
                + ", telefono=" + telefono 
                + ", fechaNacimiento=" + (fechaNacimiento == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(fechaNacimiento))
                + '}';
    }
}
