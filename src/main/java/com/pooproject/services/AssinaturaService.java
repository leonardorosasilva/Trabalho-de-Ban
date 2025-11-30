package com.pooproject.services;

import com.pooproject.model.AssinaturaModel;

import java.util.List;
import java.util.Optional;

public interface AssinaturaService {
    List<AssinaturaModel> findAll();
    Optional<AssinaturaModel> findById(int id);
    AssinaturaModel create(AssinaturaModel assinatura);
    AssinaturaModel update(int id, AssinaturaModel assinatura);
    void delete(int id);
}

