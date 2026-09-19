package com.example.api_carros.service;

import com.example.api_carros.model.entity.Marca;
import com.example.api_carros.model.repository.MarcaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public List<Marca> getMarca (){
        return this.marcaRepository.findAll();
    }


    public int deleteMarca(Long id) {
        marcaRepository.deleteById(id);
        return 0;
    }

    public Marca getMarcaPorId(Long id) {
         Marca marca = findById(id);
        return marca;
    }

    public Marca findById(Long id) {
        return  this.marcaRepository.findById(id).orElse(null);
    }

    public void save(Marca marca){
        marca.setCarros(marca.getCarros());
        marca.setId(marca.getId());
        marca.setNome(marca.getNome());

        marcaRepository.save(marca);
    }

    public void update(Marca marca){
       Marca marca1 = findById(marca.getId());
       marca.setCarros(marca.getCarros());
       marca.setNome(marca.getNome());
       marca.setId(marca.getId());

       marcaRepository.save(marca);
    }

    public void delete(Long id) {
        findById(id);
        deleteMarca(id);
    }

    public Marca buscarPorId(Long id){
        Marca marca = findById(id);
        marca.setId(marca.getId());
        marca.setNome(marca.getNome());
        marca.setCarros(marca.getCarros());

        new ArrayList<>();

        return marca;
    }

}
