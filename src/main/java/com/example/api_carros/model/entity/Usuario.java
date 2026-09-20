package com.example.api_carros.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators; // Ajustado (plural)
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
@JsonAutoDetect
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária ideal para IDENTITY

    @Column(name = "nome", length = 45)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "O nome do carro não pode conter números ou caracteres especiais")
    private String nome;

    @Column(name = "email", length = 256)
    private String email;

    // Se é OneToMany (Um para Muitos), deve ser uma List ou Set de Carros
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
// Corrigido para 'access'
    private List<Carro> carros = new ArrayList<>();

}