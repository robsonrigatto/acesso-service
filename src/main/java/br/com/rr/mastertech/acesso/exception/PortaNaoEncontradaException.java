package br.com.rr.mastertech.acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "porta não encontrada")
public class PortaNaoEncontradaException extends RuntimeException {
}
