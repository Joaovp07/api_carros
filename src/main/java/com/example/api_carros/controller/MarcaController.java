package com.example.api_carros.controller;

import com.example.api_carros.model.entity.Marca;
import com.example.api_carros.service.MarcaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/marca")
@AllArgsConstructor
public class MarcaController {

    private MarcaService marcaService;
    @GetMapping
    public ResponseEntity<String> status(){
        return  ResponseEntity.ok("Carro-ok");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Marca>>getMarca(){

        return ResponseEntity.ok(marcaService.getMarca());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String>save (@RequestBody Marca marca){
        String mensagem = "Salvo com sucesso";
        this.marcaService.save(marca);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Marca marca = marcaService.buscarPorId(id);
            return ResponseEntity.ok(marca);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("ID não encontrado!!!");
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> update(@Validated @RequestBody Marca marca, @PathVariable Long id){
        this.marcaService.update(marca);
        String mensagem = "Marca editada com sucesso!Seu id é" +id;
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (id != null) {
            this.marcaService.delete(id);
            String mensagem = "Marca deletada com sucesso!Seu id é: " + id;
            return ResponseEntity.ok().body(mensagem);
        } else {
            String mensagem = "Marca com ID " + id + " não pôde ser excluído.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
        }
    }
}
