package br.com.rr.mastertech.acesso.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AcessoIdentity implements Serializable {

    @Column(name = "pessoa_id")
    private Integer pessoaId;

    @Column(name = "porta_id")
    private Integer portaId;

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Integer getPortaId() {
        return portaId;
    }

    public void setPortaId(Integer portaId) {
        this.portaId = portaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcessoIdentity that = (AcessoIdentity) o;
        return Objects.equals(pessoaId, that.pessoaId) &&
                Objects.equals(portaId, that.portaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pessoaId, portaId);
    }
}
