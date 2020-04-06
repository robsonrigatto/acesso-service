package br.com.rr.mastertech.acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "acesso não encontrado")
public class AcessoNaoEncontradoException extends RuntimeException {
}
