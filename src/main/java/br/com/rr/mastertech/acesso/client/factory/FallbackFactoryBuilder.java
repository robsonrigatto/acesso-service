package br.com.rr.mastertech.acesso.client.factory;

import com.netflix.client.ClientException;
import feign.RetryableException;

import java.util.function.Function;

public class FallbackFactoryBuilder {

    public static <T, U extends T> Function<Exception, T> build(U factory) {
        return e -> {
            if(e instanceof RetryableException || (e.getCause() != null && e.getCause() instanceof ClientException)) {
                return factory;
            }

            if(e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }

            return null;
        };
    }
}
