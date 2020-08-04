package br.com.rr.mastertech.acesso.client.fallback;

import br.com.rr.mastertech.acesso.client.PortaClient;
import br.com.rr.mastertech.acesso.client.dto.PortaDTO;
import br.com.rr.mastertech.acesso.exception.PortaOfflineException;

public class PortaClientFallback implements PortaClient {

    @Override
    public PortaDTO findById(Integer id) {
        throw new PortaOfflineException();
    }
}
