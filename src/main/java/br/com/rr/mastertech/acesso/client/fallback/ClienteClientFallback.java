package br.com.rr.mastertech.acesso.client.fallback;

import br.com.rr.mastertech.acesso.client.ClienteClient;
import br.com.rr.mastertech.acesso.client.dto.ClienteDTO;
import br.com.rr.mastertech.acesso.exception.ClienteOfflineException;

public class ClienteClientFallback implements ClienteClient {

    @Override
    public ClienteDTO findById(Integer id) {
        throw new ClienteOfflineException();
    }
}
