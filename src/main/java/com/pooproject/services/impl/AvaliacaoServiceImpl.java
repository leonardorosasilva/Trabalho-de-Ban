package com.pooproject.services.impl;

import com.pooproject.model.AvaliacaoModel;
import com.pooproject.repository.AvaliacaoRepository;
import com.pooproject.services.AvaliacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {
    private final AvaliacaoRepository repository;

    public AvaliacaoServiceImpl(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AvaliacaoModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AvaliacaoModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public AvaliacaoModel create(AvaliacaoModel avaliacao) {
        return repository.save(avaliacao);
    }

    @Override
    public AvaliacaoModel update(int id, AvaliacaoModel avaliacao) {
        avaliacao.setIdAvaliacao(id);
        return repository.save(avaliacao);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

