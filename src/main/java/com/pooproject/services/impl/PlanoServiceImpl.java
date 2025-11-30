package com.pooproject.services.impl;

import com.pooproject.model.PlanoModel;
import com.pooproject.repository.PlanoRepository;
import com.pooproject.services.PlanoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoServiceImpl implements PlanoService {
    private final PlanoRepository repository;

    public PlanoServiceImpl(PlanoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PlanoModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PlanoModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public PlanoModel create(PlanoModel plano) {
        return repository.save(plano);
    }

    @Override
    public PlanoModel update(int id, PlanoModel plano) {
        plano.setIdPlano(id);
        return repository.save(plano);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

