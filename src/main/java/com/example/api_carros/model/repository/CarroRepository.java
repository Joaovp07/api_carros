package com.example.api_carros.model.repository;

import com.example.api_carros.model.entity.Carro;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface CarroRepository  extends JpaRepository<Carro, Long> {

    Carro findById(SingularAttribute<AbstractPersistable, Serializable> id);
}

