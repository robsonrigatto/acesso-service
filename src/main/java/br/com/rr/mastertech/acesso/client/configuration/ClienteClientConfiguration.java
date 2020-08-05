package br.com.rr.mastertech.acesso.client.configuration;

import br.com.rr.mastertech.acesso.client.fallback.ClienteClientFallback;
import br.com.rr.mastertech.acesso.client.decoder.ClienteClientDecoder;
import br.com.rr.mastertech.acesso.client.factory.FallbackFactoryBuilder;
import feign.Feign;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class ClienteClientConfiguration {

    @Bean
    public ErrorDecoder clientErrorDecoder() {
        return new ClienteClientDecoder();
    }

    @Bean
    public Feign.Builder clientBuilder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(FallbackFactoryBuilder.build(new ClienteClientFallback()))
//                .withFallback(new ClienteClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
