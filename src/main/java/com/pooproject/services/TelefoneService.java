package com.pooproject.services;

import com.pooproject.model.TelefoneModel;

import java.util.List;
import java.util.Optional;

public interface TelefoneService {
    List<TelefoneModel> findAll();
    Optional<TelefoneModel> findById(int id);
    TelefoneModel create(TelefoneModel telefone);
    TelefoneModel update(int id, TelefoneModel telefone);
    void delete(int id);
}

