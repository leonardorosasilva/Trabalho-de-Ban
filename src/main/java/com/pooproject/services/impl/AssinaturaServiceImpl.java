package com.pooproject.services.impl;

import com.pooproject.model.AssinaturaModel;
import com.pooproject.repository.AssinaturaRepository;
import com.pooproject.services.AssinaturaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaServiceImpl implements AssinaturaService {
    private final AssinaturaRepository repository;

    public AssinaturaServiceImpl(AssinaturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AssinaturaModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AssinaturaModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public AssinaturaModel create(AssinaturaModel assinatura) {
        return repository.save(assinatura);
    }

    @Override
    public AssinaturaModel update(int id, AssinaturaModel assinatura) {
        assinatura.setIdAssinatura(id);
        return repository.save(assinatura);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

