package br.com.rr.mastertech.acesso.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AcessoRequest {

    @JsonProperty("cliente_id")
    private Integer clienteId;

    @JsonProperty("porta_id")
    private Integer portaId;
}
