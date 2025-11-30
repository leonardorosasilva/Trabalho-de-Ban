package com.pooproject.services;

import com.pooproject.model.EmailModel;

import java.util.List;
import java.util.Optional;

public interface EmailService {
    List<EmailModel> findAll();
    Optional<EmailModel> findById(int id);
    EmailModel create(EmailModel email);
    EmailModel update(int id, EmailModel email);
    void delete(int id);
}

