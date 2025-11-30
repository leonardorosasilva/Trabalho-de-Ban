package com.pooproject.services.impl;

import com.pooproject.model.UsuarioModel;
import com.pooproject.repository.UsuarioRepository;
import com.pooproject.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UsuarioModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UsuarioModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public UsuarioModel create(UsuarioModel usuario) {
        return repository.save(usuario);
    }

    @Override
    public UsuarioModel update(int id, UsuarioModel usuario) {
        usuario.setIdUsuario(id);
        return repository.save(usuario);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

