package br.com.rr.mastertech.acesso.controller;

import br.com.rr.mastertech.acesso.dto.request.AcessoRequest;
import br.com.rr.mastertech.acesso.dto.response.AcessoResponse;
import br.com.rr.mastertech.acesso.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @GetMapping("/{clienteId}/{portaId}")
    public AcessoResponse find(@PathVariable Integer clienteId, @PathVariable Integer portaId) {
        return acessoService.find(clienteId, portaId);
    }

    @PostMapping
    public AcessoResponse create(@Valid @RequestBody AcessoRequest request) {
        return acessoService.create(request.getClienteId(), request.getPortaId());
    }

    @DeleteMapping("/{clienteId}/{portaId}")
    public ResponseEntity<Void> delete(@PathVariable Integer clienteId, @PathVariable Integer portaId) {
        acessoService.delete(clienteId, portaId);
        return ResponseEntity.noContent().build();
    }
}
