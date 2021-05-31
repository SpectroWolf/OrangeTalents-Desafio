package br.com.zup.desafio.controllers;

import br.com.zup.desafio.models.Veiculo;
import br.com.zup.desafio.services.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FipeService fipeService;

    @GetMapping("{marca}/{modelo}/{ano}")
    public ResponseEntity<Veiculo> getCar(@PathVariable String marca,
                                          @PathVariable String modelo,
                                          @PathVariable String ano){
        Veiculo veiculo = fipeService.getCar(marca,modelo,ano);
        return ResponseEntity.ok().body(veiculo);
    }
}
