package br.com.rr.mastertech.acesso.client.decoder;

import br.com.rr.mastertech.acesso.exception.ClienteNaoEncontradaException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new ClienteNaoEncontradaException();
        }

        return errorDecoder.decode(s, response);
    }

}
