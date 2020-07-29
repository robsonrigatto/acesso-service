package br.com.rr.mastertech.acesso.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Acesso {

    @EmbeddedId
    private AcessoIdentity id;

    public AcessoIdentity getId() {
        return id;
    }

    public void setId(AcessoIdentity id) {
        this.id = id;
    }
}
