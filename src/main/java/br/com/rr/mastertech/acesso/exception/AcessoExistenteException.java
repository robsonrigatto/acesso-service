package br.com.rr.mastertech.acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "acesso já existe")
public class AcessoExistenteException extends RuntimeException {
}
