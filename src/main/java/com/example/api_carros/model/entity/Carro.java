package com.example.api_carros.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "nome")
    private String nome;

    @Column(name ="modelo")
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
