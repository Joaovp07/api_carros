package com.example.api_carros.model.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",length = 45)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "O nome do carro não pode conter números ou caracteres especiais")
    private String nome;

    @OneToMany(mappedBy = "marca", fetch = FetchType.EAGER)
// Corrigido para 'access'
    private List<Carro> carros = new ArrayList<>();
}
