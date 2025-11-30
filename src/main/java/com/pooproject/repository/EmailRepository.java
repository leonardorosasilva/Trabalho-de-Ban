package com.pooproject.repository;

import com.pooproject.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Integer> {
}
