package com.example.api_carros.model.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Marca")
@JsonAutoDetect
@JsonIdentityInfo(
        scope = Marca.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id" // É necessário indicar qual campo é o ID para o Jackson
)
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "marca", fetch = FetchType.EAGER)
// Corrigido para 'access'
    private List<Carro> carros = new ArrayList<>();
}
