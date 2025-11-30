package com.pooproject.services.impl;

import com.pooproject.model.TelefoneModel;
import com.pooproject.repository.TelefoneRepository;
import com.pooproject.services.TelefoneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneServiceImpl implements TelefoneService {
    private final TelefoneRepository repository;

    public TelefoneServiceImpl(TelefoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TelefoneModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TelefoneModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public TelefoneModel create(TelefoneModel telefone) {
        return repository.save(telefone);
    }

    @Override
    public TelefoneModel update(int id, TelefoneModel telefone) {
        telefone.setIdTelefone(id);
        return repository.save(telefone);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

