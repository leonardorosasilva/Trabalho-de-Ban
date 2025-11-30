package com.pooproject.services;

import com.pooproject.model.AvaliacaoModel;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoService {
    List<AvaliacaoModel> findAll();
    Optional<AvaliacaoModel> findById(int id);
    AvaliacaoModel create(AvaliacaoModel avaliacao);
    AvaliacaoModel update(int id, AvaliacaoModel avaliacao);
    void delete(int id);
}

