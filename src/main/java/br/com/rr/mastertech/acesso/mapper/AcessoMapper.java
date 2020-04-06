package br.com.rr.mastertech.acesso.mapper;

import br.com.rr.mastertech.acesso.domain.Acesso;
import br.com.rr.mastertech.acesso.dto.response.AcessoResponse;
import org.springframework.stereotype.Component;

@Component
public class AcessoMapper {

    public AcessoResponse toAcessoResponse(Acesso acesso) {
        return AcessoResponse.builder().clienteId(acesso.getId().getPortaId())
            .pessoaId(acesso.getId().getPessoaId()).build();
    }
}
