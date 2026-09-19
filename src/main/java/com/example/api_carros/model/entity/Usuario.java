package com.example.api_carros.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators; // Ajustado (plural)
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List; // Import necessário para listas

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@ToString
@JsonIdentityInfo(
        scope = Usuario.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id" // É necessário indicar qual campo é o ID para o Jackson
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária ideal para IDENTITY

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    // Se é OneToMany (Um para Muitos), deve ser uma List ou Set de Carros
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
// Corrigido para 'access'
    private List<Carro> carros = new ArrayList<>();

}