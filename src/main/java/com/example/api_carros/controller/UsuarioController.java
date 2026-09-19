package com.example.api_carros.controller;

import com.example.api_carros.model.entity.Usuario;
import com.example.api_carros.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor

    public class UsuarioController {
        private UsuarioService usuarioService;
    //private UsuarioController Service;

    @GetMapping
        public ResponseEntity<String> status(){
            return ResponseEntity.ok("Cliente-ok");
        }
        @GetMapping("/list")
        public ResponseEntity<?> getUsuario() {

            List<Usuario> listaDeUsuarios = usuarioService.getUsuario();


            if (listaDeUsuarios.isEmpty()) {
                String mensagem = "Lista Vazia!!!";
                return ResponseEntity.ok(mensagem);
            }


            return ResponseEntity.ok(listaDeUsuarios);
        }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String>save (@RequestBody Usuario usuario){
        String mensagem = "Carro criado com sucesso"  + usuario.getNome();
        this.usuarioService.save(usuario);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<String> findById(@PathVariable Long id){
        try {
          Usuario usuario = usuarioService.getUsuarioPorId(id);
            return ResponseEntity.ok(String.valueOf(usuario));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("ID não encontrado!!!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@Validated @RequestBody Usuario usuario, @PathVariable Long id){
        this.usuarioService.update(usuario);
        String mensagem = "Cliente editado com sucesso!Seu id é:" + id;
        return ResponseEntity.ok(mensagem);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id != null) {

            this.usuarioService.delete(id);
            String mensagem = "Cliente deletado com sucesso!Seu id é:" +id;

            return ResponseEntity.ok().body(mensagem);
        }else{
            String mensagem = "Cliente com ID" + id + "não pode ser excluido.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
        }
    }

    }

