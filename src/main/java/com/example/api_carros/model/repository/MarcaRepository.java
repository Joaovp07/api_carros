package com.example.api_carros.model.repository;

import com.example.api_carros.model.entity.Marca;
import com.example.api_carros.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}

