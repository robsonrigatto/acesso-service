package br.com.rr.mastertech.acesso.mapper;

import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;
import br.com.rr.mastertech.acesso.client.dto.PortaDTO;
import br.com.rr.mastertech.acesso.domain.Acesso;
import br.com.rr.mastertech.acesso.domain.AcessoIdentity;
import br.com.rr.mastertech.acesso.dto.response.AcessoResponse;
import org.springframework.stereotype.Component;

@Component
public class AcessoMapper {

    public AcessoResponse toAcessoResponse(Acesso acesso) {
        AcessoResponse response = new AcessoResponse();
        response.setPortaId(acesso.getId().getPortaId());
        response.setPessoaId(acesso.getId().getPessoaId());
        return response;
    }

    public Acesso toAcesso(ClienteDTO cliente, PortaDTO porta) {
        AcessoIdentity id = new AcessoIdentity();
        id.setPessoaId(cliente.getId());
        id.setPortaId(porta.getId());

        Acesso acesso = new Acesso();
        acesso.setId(id);

        return acesso;
    }
}
