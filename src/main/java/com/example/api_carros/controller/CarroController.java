package com.example.api_carros.controller;

import com.example.api_carros.model.entity.Carro;
import com.example.api_carros.model.entity.Usuario;
import com.example.api_carros.service.CarroService;
import com.example.api_carros.service.UsuarioService;
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
    public ResponseEntity<List<Carro>>getCarro(){

        return ResponseEntity.ok(carroService.getCarros());
}
@PostMapping

    public ResponseEntity<String>save (@RequestBody Carro carro){
        String mensagem = "Carro criado com sucesso" + carro.getNome();
        this.carroService.save(carro);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        if (id != null) {
            return ResponseEntity.ok(this.carroService.buscarPorId(id));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body((null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@Validated @RequestBody Carro carro, @PathVariable Long id){

        this.carroService.update(carro);
        String mensagem = "Cliente editado com sucesso!Seu id é:" + id;
        return ResponseEntity.ok(mensagem);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        if (id != null) {

            this.carroService.delete(id);
            String mensagem = "Cliente deletado com sucesso!Seu id é:" +id;

            return ResponseEntity.ok().body(mensagem);
        }else{
            String mensagem = "Cliente com ID" + id + "não pode ser excluido.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagem);
        }
    }
}
