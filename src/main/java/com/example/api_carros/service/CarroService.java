package com.example.api_carros.service;

import com.example.api_carros.model.entity.Carro;
import com.example.api_carros.model.entity.Usuario;
import com.example.api_carros.model.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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



    public int deleteCarro(Long id) {
        carroRepository.deleteById(id);
        return 0;
    }

    public Carro getCarroPorId(Long id) {
        Carro carro = findById(id);
        return carro;
    }

   public Carro findById(Long id) {
        return  this.carroRepository.findById(id).orElse(null);
   }



    public void save(Carro carro){
        carro.setMarca(carro.getMarca());
        carro.setModelo(carro.getModelo());
        carro.setNome(carro.getNome());
        carro.setUsuario(carro.getUsuario());



        carroRepository.save(carro);
    }

    public void update(Carro carro){
      Carro carro1 = findById(carro.getId());
      //if ()
      //  carro1.setId(carro1.getId(id));
        carro.setMarca(carro.getMarca());
        carro.setModelo(carro.getModelo());
        carro.setNome(carro.getNome());
        carro.setUsuario(carro.getUsuario());
        carroRepository.save(carro);

    }
    
    public void delete(Long id) {
        findById(id);
        deleteCarro(id);
    }

    public Carro buscarPorId(Long id){
         Carro carro = findById(id);
         carro.setId(carro.getId());
         carro.setNome(carro.getNome());
         carro.setMarca(carro.getMarca());
         carro.setModelo(carro.getModelo());
         carro.setUsuario(carro.getUsuario());

         new ArrayList<>();

         return carro;
    }


}
