package com.pooproject.repository;

import com.pooproject.model.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, Integer> {
    Optional<PlanoModel> findByNome(String nome);
}

