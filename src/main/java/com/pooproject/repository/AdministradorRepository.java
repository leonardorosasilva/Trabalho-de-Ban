package com.pooproject.repository;

import com.pooproject.model.AdministradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorModel, Integer> {
}

