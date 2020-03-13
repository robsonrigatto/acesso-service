package br.com.rr.mastertech.acesso.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcessoResponse {

    @JsonProperty("porta_id")
    private Integer portaId;

    @JsonProperty("pessoa_id")
    private Integer pessoaId;
}
