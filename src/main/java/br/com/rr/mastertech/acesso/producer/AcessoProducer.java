package br.com.rr.mastertech.acesso.producer;

import br.com.rr.mastertech.acesso.producer.dto.AcessoClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AcessoProducer {

    @Autowired
    private KafkaTemplate<String, AcessoClienteDTO> producer;

    public void send(AcessoClienteDTO acesso) {
        producer.send("spec3-robson-rigatto-1", acesso);
    }
}
