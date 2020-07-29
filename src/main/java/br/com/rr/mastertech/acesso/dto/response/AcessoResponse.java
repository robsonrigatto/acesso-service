package br.com.rr.mastertech.acesso.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
public class AcessoResponse {

    @JsonProperty("porta_id")
    private Integer portaId;

    @JsonProperty("pessoa_id")
    private Integer pessoaId;

    public Integer getPortaId() {
        return portaId;
    }

    public void setPortaId(Integer portaId) {
        this.portaId = portaId;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }
}
