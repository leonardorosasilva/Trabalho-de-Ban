package com.pooproject.repository;

import com.pooproject.model.AssinaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaturaModel, Integer> {
}

