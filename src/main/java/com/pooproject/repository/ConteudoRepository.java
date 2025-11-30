package com.pooproject.repository;

import com.pooproject.model.ConteudoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConteudoRepository extends JpaRepository<ConteudoModel, Integer> {
    Optional<ConteudoModel> findByTitulo(String titulo);
}

