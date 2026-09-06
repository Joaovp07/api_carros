package com.example.api_carros.controller;

import com.example.api_carros.entity.Carro;
import com.example.api_carros.entity.Usuario;
import com.example.api_carros.service.CarroService;
import com.example.api_carros.service.UsuarioService;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@AllArgsConstructor
public class CarroController {
    private final CarroService carroService;
    private final UsuarioService usuarioService;
@GetMapping("/list")
    public ResponseEntity<List<Usuario>> ListaCarros(){
//        List<Carro> carros = carroService.getCarros();
        return ResponseEntity.ok(usuarioService.getUsuario());


    }
@PostMapping("/save")
    public ResponseEntity<String>save (@RequestBody Carro carro){
    String mensagem = "Carro criado com sucesso! Seu nome é " + carro.getNome();
    this.carroService.saveCarro(carro);
    return ResponseEntity.ok(mensagem);
    }

}
