package br.com.rr.mastertech.acesso.client;

import br.com.rr.mastertech.acesso.client.dto.PortaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "porta")
@RequestMapping("/porta")
public interface PortaClient {

    @GetMapping("/{id}")
    public PortaDTO findById(@PathVariable Integer id);
}
