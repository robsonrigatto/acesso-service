package br.com.rr.mastertech.acesso.service;

import br.com.rr.mastertech.acesso.client.ClienteClient;
import br.com.rr.mastertech.acesso.client.PortaClient;
import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;
import br.com.rr.mastertech.acesso.client.dto.PortaDTO;
import br.com.rr.mastertech.acesso.domain.Acesso;
import br.com.rr.mastertech.acesso.domain.AcessoIdentity;
import br.com.rr.mastertech.acesso.dto.response.AcessoResponse;
import br.com.rr.mastertech.acesso.exception.*;
import br.com.rr.mastertech.acesso.mapper.AcessoMapper;
import br.com.rr.mastertech.acesso.repository.AcessoRepository;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AcessoService {

    @Autowired
    private AcessoMapper acessoMapper;

    @Autowired
    private AcessoRepository acessoRepository;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private PortaClient portaClient;

    public AcessoResponse find(Integer clienteId, Integer portaId) {
        ClienteDTO cliente = this.findCliente(clienteId);
        PortaDTO porta = this.findPorta(portaId);

        AcessoIdentity id = new AcessoIdentity(cliente.getId(), porta.getId());
        Optional<Acesso> acessoOptional = acessoRepository.findById(id);

        Acesso acesso = acessoOptional.orElseThrow(() -> new AcessoNaoEncontradoException());
        return acessoMapper.toAcessoResponse(acesso);
    }

    public AcessoResponse create(Integer clienteId, Integer portaId) {
        ClienteDTO cliente = this.findCliente(clienteId);
        PortaDTO porta = this.findPorta(portaId);

        AcessoIdentity id = new AcessoIdentity(cliente.getId(), porta.getId());
        Optional<Acesso> acessoOptional = acessoRepository.findById(id);

        Acesso acesso = acessoOptional.orElse(Acesso.builder().id(id).build());
        acesso = acessoRepository.save(acesso);

        return acessoMapper.toAcessoResponse(acesso);
    }

    @Transactional
    public void delete(Integer clienteId, Integer portaId) {
        ClienteDTO cliente = this.findCliente(clienteId);
        PortaDTO porta = this.findPorta(portaId);

        AcessoIdentity id = new AcessoIdentity(cliente.getId(), porta.getId());
        acessoRepository.deleteById(id);
    }

    private ClienteDTO findCliente(Integer pessoaId) {
        try {
            return clienteClient.findById(pessoaId);

        } catch (HystrixRuntimeException ex) {
            if(ex.getCause() instanceof FeignException.NotFound) {
                throw new ClienteNaoEncontradaException();
            }
            throw new ClienteOfflineException();
        }
    }

    private PortaDTO findPorta(Integer portaId) {
        try {
            return portaClient.findById(portaId);

        } catch (HystrixRuntimeException ex) {
            if(ex.getCause() instanceof FeignException.NotFound) {
                throw new PortaNaoEncontradaException();
            }
            throw new PortaOfflineException();
        }
    }
}
