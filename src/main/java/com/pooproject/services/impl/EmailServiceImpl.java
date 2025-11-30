package com.pooproject.services.impl;

import com.pooproject.model.EmailModel;
import com.pooproject.repository.EmailRepository;
import com.pooproject.services.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository repository;

    public EmailServiceImpl(EmailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmailModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EmailModel> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public EmailModel create(EmailModel email) {
        return repository.save(email);
    }

    @Override
    public EmailModel update(int id, EmailModel email) {
        email.setIdEmail(id);
        return repository.save(email);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

