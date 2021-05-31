package br.com.zup.desafio.controllers;

import br.com.zup.desafio.models.Usuario;
import br.com.zup.desafio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<?> insert(@RequestBody Usuario usuario){
        try{
            usuarioService.insert(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro de usuário realizado com sucesso!");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar o usuário");
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id){
        try{
            Usuario usuario = usuarioService.find(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado.");
        }
    }

}
