package br.com.rr.mastertech.acesso.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcessoRequest {

    @JsonProperty("cliente_id")
    private Integer clienteId;

    @JsonProperty("porta_id")
    private Integer portaId;

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getPortaId() {
        return portaId;
    }

    public void setPortaId(Integer portaId) {
        this.portaId = portaId;
    }
}
