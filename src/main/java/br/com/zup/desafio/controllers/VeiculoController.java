package br.com.zup.desafio.controllers;

import br.com.zup.desafio.models.Veiculo;
import br.com.zup.desafio.services.UsuarioService;
import br.com.zup.desafio.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    FeignController feignController;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/marca/{marca}/modelo/{modelo}/ano/{ano}")
    public ResponseEntity<?> insert(@PathVariable("marca") String marca,
                                    @PathVariable("modelo") String modelo,
                                    @PathVariable("ano") String ano){
        try {
            Veiculo veiculo = feignController.getCar(marca, modelo, ano).getBody();
            veiculoService.insert(veiculo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro de veiculo realizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao tentar localizar o veiculo");
        }
    }

    @GetMapping("/veiculo/{id}")
    public ResponseEntity<?> getVeiculoById(@PathVariable Long id){

        try{
            Veiculo veiculo = veiculoService.find(id);
            return ResponseEntity.status(HttpStatus.OK).body(veiculo);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veiculo não encontrado.");
        }
    }

    @PutMapping("vincular/{userId}/{veiculoId}")
    public ResponseEntity<?> vincularVeiculo(@PathVariable("userId") Long userId,
                                             @PathVariable("veiculoId") Long veiculoId){
        try {
            usuarioService.vincular(userId, veiculoId);
            return ResponseEntity.status(HttpStatus.OK).body("Veiculo vinculado ao usuário com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body("Erro ao tentar vincular o veiculo a um usuário");
        }
    }
}
