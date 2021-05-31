package br.com.zup.desafio.services;

import br.com.zup.desafio.models.Veiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "http://fipeapi.appspot.com/api/1/carros/veiculo/", name = "fipeApi")
public interface FipeService {

    @GetMapping("{marca}/{modelo}/{ano}.json")
    Veiculo getCar(@PathVariable("marca") String marca,
                   @PathVariable("modelo") String modelo,
                   @PathVariable("ano") String ano);
}
