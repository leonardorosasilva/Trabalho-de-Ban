package com.pooproject.services.impl;

import com.pooproject.model.ConteudoModel;
import com.pooproject.repository.ConteudoRepository;
import com.pooproject.services.ConteudoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConteudoServiceImpl implements ConteudoService {
    private final ConteudoRepository repository;

    public ConteudoServiceImpl(ConteudoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ConteudoModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ConteudoModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ConteudoModel create(ConteudoModel conteudo) {
        return repository.save(conteudo);
    }

    @Override
    public ConteudoModel update(int id, ConteudoModel conteudo) {
        conteudo.setIdConteudo(id);
        return repository.save(conteudo);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

