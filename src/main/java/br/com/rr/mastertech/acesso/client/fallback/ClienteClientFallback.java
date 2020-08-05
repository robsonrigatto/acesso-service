package br.com.rr.mastertech.acesso.client.fallback;

import br.com.rr.mastertech.acesso.exception.ClienteOfflineException;
import br.com.rr.mastertech.acesso.client.ClienteClient;
import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;

public class ClienteClientFallback implements ClienteClient {

    @Override
    public ClienteDTO findById(Integer id) {
        throw new ClienteOfflineException();
    }
}
