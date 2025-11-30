package com.pooproject.services;

import com.pooproject.model.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteModel> findAll();
    Optional<ClienteModel> findById(int id);
    ClienteModel create(ClienteModel cliente);
    ClienteModel update(int id, ClienteModel cliente);
    void delete(int id);
}
