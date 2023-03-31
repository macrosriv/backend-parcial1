/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.dto;

/**
 *
 * @author macro
 */
public class Respuesta {
    private Boolean exito;
    private Integer codigo;
    private Object mensaje;

    public Respuesta() {
    }

    public Respuesta(Boolean exito, Integer codigo, Object mensaje) {
        this.exito = exito;
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public Boolean getExito() {
        return exito;
    }

    public void setExito(Boolean exito) {
        this.exito = exito;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Object getMensaje() {
        return mensaje;
    }

    public void setMensaje(Object mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "exito=" + exito + ", codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }
}
