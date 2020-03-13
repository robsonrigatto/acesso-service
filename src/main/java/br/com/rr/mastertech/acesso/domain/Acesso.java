package br.com.rr.mastertech.acesso.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@Builder
public class Acesso {

    @EmbeddedId
    private AcessoIdentity id;
}
