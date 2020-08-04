package br.com.rr.mastertech.acesso.client;

import br.com.rr.mastertech.acesso.client.configuration.ClienteClientConfiguration;
import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cliente", configuration = ClienteClientConfiguration.class)
@RequestMapping("/cliente")
public interface ClienteClient {

    @GetMapping("/{id}")
    ClienteDTO findById(@PathVariable Integer id);
}
