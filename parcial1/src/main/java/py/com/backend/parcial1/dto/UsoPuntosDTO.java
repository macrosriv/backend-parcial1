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
public class UsoPuntosDTO {
    private Integer clienteId;
    private Integer conceptoId;

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(Integer conceptoId) {
        this.conceptoId = conceptoId;
    }

    @Override
    public String toString() {
        return "UsoPuntosDTO{" + "clienteId=" + clienteId + ", conceptoId=" + conceptoId + '}';
    }
}
