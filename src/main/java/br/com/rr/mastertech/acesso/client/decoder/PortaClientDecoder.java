package br.com.rr.mastertech.acesso.client.decoder;

import br.com.rr.mastertech.acesso.exception.PortaNaoEncontradaException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PortaClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new PortaNaoEncontradaException();
        }

        return errorDecoder.decode(s, response);
    }

}
