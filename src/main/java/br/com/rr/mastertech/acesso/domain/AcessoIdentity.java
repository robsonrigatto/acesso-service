package br.com.rr.mastertech.acesso.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcessoIdentity implements Serializable {

    @Column(name = "pessoa_id")
    private Integer pessoaId;

    @Column(name = "porta_id")
    private Integer portaId;
}
