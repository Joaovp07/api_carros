package com.example.api_carros.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Pattern;
import tools.jackson.databind.annotation.JsonDeserialize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Carro")
@JsonAutoDetect
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 45)
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "O nome do carro não pode conter números ou caracteres especiais")
    private String nome;

    @Column(name ="modelo", length = 45)
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "O nome do carro não pode conter números ou caracteres especiais")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id") // Nome da coluna que vai ligar na tabela Carro
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, namespace = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "usuario_id") // Nome da coluna que vai ligar na tabela Carro
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, namespace = "usuario_id")
    private Usuario usuario;
}
