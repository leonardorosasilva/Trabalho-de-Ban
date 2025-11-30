package com.pooproject.repository;

import com.pooproject.model.TelefoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneModel, Integer> {
}

