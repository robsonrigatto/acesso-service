package br.com.rr.mastertech.acesso.client.configuration;

import br.com.rr.mastertech.acesso.client.decoder.PortaClientDecoder;
import br.com.rr.mastertech.acesso.client.factory.FallbackFactoryBuilder;
import br.com.rr.mastertech.acesso.client.fallback.PortaClientFallback;
import feign.Feign;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class PortaClientConfiguration {

    @Bean
    public ErrorDecoder portaErrorDecoder() {
        return new PortaClientDecoder();
    }

    @Bean
    public Feign.Builder portaBuilder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(FallbackFactoryBuilder.build(new PortaClientFallback()))
                //.withFallback(new PortaClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
