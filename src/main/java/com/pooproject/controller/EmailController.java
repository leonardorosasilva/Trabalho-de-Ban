package com.pooproject.controller;

import com.pooproject.dto.EmailDto;
import com.pooproject.model.EmailModel;
import com.pooproject.model.UsuarioModel;
import com.pooproject.repository.EmailRepository;
import com.pooproject.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailRepository repository;
    private final UsuarioRepository usuarioRepository;

    public EmailController(EmailRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<EmailDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailDto> getById(@PathVariable int id) {
        return repository.findById(id).map(e -> ResponseEntity.ok(toDto(e))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmailDto> create(@RequestBody EmailDto dto) {
        EmailModel m = toEntity(dto);
        EmailModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/emails/" + saved.getIdEmail())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailDto> update(@PathVariable int id, @RequestBody EmailDto dto) {
        EmailModel m = toEntity(dto);
        m.setIdEmail(id);
        EmailModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private EmailDto toDto(EmailModel m) {
        Integer usuarioId = m.getUsuario() != null ? m.getUsuario().getIdUsuario() : null;
        return new EmailDto(m.getIdEmail(), usuarioId, m.getEmail());
    }

    private EmailModel toEntity(EmailDto d) {
        EmailModel m = new EmailModel();
        if (d.idEmail() != null) m.setIdEmail(d.idEmail());
        m.setEmail(d.email());
        if (d.usuarioId() != null) usuarioRepository.findById(d.usuarioId()).ifPresent(m::setUsuario);
        return m;
    }
}

