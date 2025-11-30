package com.pooproject.services.impl;

import com.pooproject.model.ClienteModel;
import com.pooproject.repository.ClienteRepository;
import com.pooproject.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClienteModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClienteModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ClienteModel create(ClienteModel cliente) {
        return repository.save(cliente);
    }

    @Override
    public ClienteModel update(int id, ClienteModel cliente) {
        cliente.setIdUsuario(id);
        return repository.save(cliente);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

