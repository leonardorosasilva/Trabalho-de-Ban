package com.pooproject.services;

import com.pooproject.model.ConteudoModel;

import java.util.List;
import java.util.Optional;

public interface ConteudoService {
    List<ConteudoModel> findAll();
    Optional<ConteudoModel> findById(int id);
    ConteudoModel create(ConteudoModel conteudo);
    ConteudoModel update(int id, ConteudoModel conteudo);
    void delete(int id);
}

