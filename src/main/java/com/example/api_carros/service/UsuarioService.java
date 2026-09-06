package com.example.api_carros.service;

import com.example.api_carros.entity.Usuario;
import com.example.api_carros.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
private final UsuarioRepository usuarioRepository;

  public List<Usuario> getUsuario() {

      return usuarioRepository.findAll();
  }
}
