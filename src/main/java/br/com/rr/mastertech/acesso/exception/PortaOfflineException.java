package br.com.rr.mastertech.acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "serviço de portas indisponível")
public class PortaOfflineException extends RuntimeException {
}
