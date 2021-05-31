package br.com.zup.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioOrangeApplication {

    public static void main(String[] args) {

        SpringApplication.run(DesafioOrangeApplication.class, args);
    }

}
