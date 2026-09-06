package com.example.api_carros.service;

import com.example.api_carros.entity.Carro;
import com.example.api_carros.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarroService { 
    private final CarroRepository carroRepository;
//    public CarroService (CarroRepository carroRepository){
//         this.carroRepository;
//    }

    public List<Carro> getCarros (){
       // List <Carro> carros = carroRepository.findAll();
                return this.carroRepository.findAll();
    }

    public void saveCarro(Carro carro){
        carro.setMarca(carro.getMarca());
        carro.setModelo(carro.getModelo());
        carro.setNome(carro.getNome());
        carro.setUsuario(carro.getUsuario());
    }
}
