package br.com.rr.mastertech.acesso.mapper;

import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;
import br.com.rr.mastertech.acesso.client.dto.PortaDTO;
import br.com.rr.mastertech.acesso.domain.Acesso;
import br.com.rr.mastertech.acesso.domain.AcessoIdentity;
import br.com.rr.mastertech.acesso.dto.response.AcessoResponse;
import br.com.rr.mastertech.acesso.producer.dto.AcessoClienteDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

    public AcessoClienteDTO toAcessoClienteDTO(ClienteDTO cliente, PortaDTO porta, Boolean temAcesso) {
        AcessoClienteDTO dto = new AcessoClienteDTO();
        dto.setIdPorta(porta.getId());
        dto.setIdCliente(cliente.getId());
        dto.setHorario(LocalDateTime.now());
        dto.setTemAcesso(temAcesso);

        return dto;
    }
}
