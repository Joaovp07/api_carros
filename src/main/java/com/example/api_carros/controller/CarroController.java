package com.example.api_carros.controller;

import com.example.api_carros.model.entity.Carro;
import com.example.api_carros.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;
    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Carro-ok");
    }
    @GetMapping("/list")
    public ResponseEntity<?> getCarro() {

        List<Carro> listaDeCarros = carroService.getCarros();


        if (listaDeCarros.isEmpty()) {
            String mensagem = "Lista Vazia!!!";
            return ResponseEntity.ok(mensagem);
        }


        return ResponseEntity.ok(listaDeCarros);
    }
@PostMapping

    public ResponseEntity<String>save (@Validated @RequestBody Carro carro){
    if (carro.getNome() == null || carro.getNome().trim().isEmpty()) {
            String mensagem = "Não pode criar o carro sem nome";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
        }else {
            String mensagem = "Carro criado com sucesso" + carro.getNome();
            this.carroService.save(carro);
            return ResponseEntity.ok(mensagem);

        }
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<String> findById(@PathVariable Long id){
        try {
            Carro carro = carroService.buscarPorId(id);
            return ResponseEntity.ok(String.valueOf(carro));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("ID não encontrado!!!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@Validated @RequestBody Carro carro, @PathVariable Long id) {
        try {

            if (carro.getId() == null) {
                this.carroService.update(carro);
                String mensagem = "Carro editado com sucesso!Seu id é:" + id;

                return ResponseEntity.ok(mensagem);
            }
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("ID não encontrado!!!");
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id != null) {

            this.carroService.delete(id);
            String mensagem = "Carro deletado com sucesso!Seu id é:" +id;

            return ResponseEntity.ok().body(mensagem);
        }else{
            String mensagem = "Carro com ID" + id + "não pode ser excluido.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
        }
    }
}
