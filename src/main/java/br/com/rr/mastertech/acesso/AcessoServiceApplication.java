package br.com.rr.mastertech.acesso;

import br.com.rr.mastertech.acesso.configuration.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class AcessoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcessoServiceApplication.class, args);
	}

}
