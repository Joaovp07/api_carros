package com.example.api_carros.repository;

import com.example.api_carros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository  extends JpaRepository<Carro, Long> {
}
