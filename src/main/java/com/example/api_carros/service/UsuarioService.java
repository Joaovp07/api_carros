package com.example.api_carros.service;

import com.example.api_carros.model.entity.Carro;
import com.example.api_carros.model.entity.Usuario;
import com.example.api_carros.model.repository.CarroRepository;
import com.example.api_carros.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
private final UsuarioRepository usuarioRepository;


  public List<Usuario> getUsuario() {

      return usuarioRepository.findAll();
  }

    public int deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return 0;
    }


  public Usuario getUsuarioPorId(Long id) {
      Usuario usuario = findById(id);
      return usuario;
  }

  public Usuario findById(Long id) {
      return this.usuarioRepository.findById(id).orElse(null);
  }



    public void save(Usuario usuario ){
      Usuario usuario1 = new Usuario();
      usuario.setNome(usuario.getNome());
      usuario.setEmail(usuario.getEmail());
      usuario.setId(usuario.getId());
      usuario.setCarros(usuario.getCarros());

      List<Carro> carros = new ArrayList<>();

      usuarioRepository.save(usuario);

  }

  public  void update(Usuario usuario) {
      Usuario usuario1 = findById(usuario.getId());
      usuario.setNome(usuario.getNome());
      usuario.setId(usuario.getId());
      usuario.setCarros(usuario.getCarros());
      usuario.setEmail(usuario.getEmail());
      usuarioRepository.save(usuario);
  }

  public void delete(Long id) {
      findById(id);
      deleteUsuario(id);
  }

  public Usuario buscaPorId(Long id) {
      Usuario usuario = findById(id);
      usuario.setNome(usuario.getNome());
      usuario.setId(usuario.getId());
      usuario.setEmail(usuario.getEmail());
      usuario.setCarros(usuario.getCarros());
      new ArrayList<>();
      return usuario;
  }




}




