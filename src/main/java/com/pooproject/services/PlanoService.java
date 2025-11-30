package com.pooproject.services;

import com.pooproject.model.PlanoModel;

import java.util.List;
import java.util.Optional;

public interface PlanoService {
    List<PlanoModel> findAll();
    Optional<PlanoModel> findById(int id);
    PlanoModel create(PlanoModel plano);
    PlanoModel update(int id, PlanoModel plano);
    void delete(int id);
}

