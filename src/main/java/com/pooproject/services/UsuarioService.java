package com.pooproject.services;

import com.pooproject.model.UsuarioModel;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioModel> findAll();
    Optional<UsuarioModel> findById(int id);
    UsuarioModel create(UsuarioModel usuario);
    UsuarioModel update(int id, UsuarioModel usuario);
    void delete(int id);
}

