package br.com.rr.mastertech.acesso.service;

import br.com.rr.mastertech.acesso.client.ClienteClient;
import br.com.rr.mastertech.acesso.client.PortaClient;
import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;
import br.com.rr.mastertech.acesso.client.dto.PortaDTO;
import br.com.rr.mastertech.acesso.domain.Acesso;
import br.com.rr.mastertech.acesso.domain.AcessoIdentity;
import br.com.rr.mastertech.acesso.dto.response.AcessoResponse;
import br.com.rr.mastertech.acesso.exception.AcessoExistenteException;
import br.com.rr.mastertech.acesso.exception.AcessoNaoEncontradoException;
import br.com.rr.mastertech.acesso.mapper.AcessoMapper;
import br.com.rr.mastertech.acesso.producer.AcessoProducer;
import br.com.rr.mastertech.acesso.repository.AcessoRepository;
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
    private AcessoProducer acessoProducer;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private PortaClient portaClient;

    public AcessoResponse find(Integer clienteId, Integer portaId) {
        ClienteDTO cliente = this.findCliente(clienteId);
        PortaDTO porta = this.findPorta(portaId);

        Acesso acesso = acessoMapper.toAcesso(cliente, porta);
        Optional<Acesso> acessoOptional = acessoRepository.findById(acesso.getId());
        acessoProducer.send(acessoMapper.toAcessoClienteDTO(cliente, porta, acessoOptional.isPresent()));

        acesso = acessoOptional.orElseThrow(() -> new AcessoNaoEncontradoException());
        return acessoMapper.toAcessoResponse(acesso);
    }

    public AcessoResponse create(Integer clienteId, Integer portaId) {
        ClienteDTO cliente = this.findCliente(clienteId);
        PortaDTO porta = this.findPorta(portaId);
        Acesso acesso = acessoMapper.toAcesso(cliente, porta);

        Optional<Acesso> acessoOptional = acessoRepository.findById(acesso.getId());
        if(acessoOptional.isPresent()) {
            throw new AcessoExistenteException();
        }

        acesso = acessoRepository.save(acesso);
        return acessoMapper.toAcessoResponse(acesso);
    }

    @Transactional
    public void delete(Integer clienteId, Integer portaId) {
        ClienteDTO cliente = this.findCliente(clienteId);
        PortaDTO porta = this.findPorta(portaId);

        AcessoIdentity id = new AcessoIdentity();
        id.setPessoaId(cliente.getId());
        id.setPortaId(porta.getId());
        acessoRepository.deleteById(id);
    }

    private ClienteDTO findCliente(Integer pessoaId) {
        return clienteClient.findById(pessoaId);
    }

    private PortaDTO findPorta(Integer portaId) {
        return portaClient.findById(portaId);
    }
}
