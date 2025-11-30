package com.pooproject.controller;

import com.pooproject.dto.TelefoneDto;
import com.pooproject.model.TelefoneModel;
import com.pooproject.repository.TelefoneRepository;
import com.pooproject.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
    private final TelefoneRepository repository;
    private final UsuarioRepository usuarioRepository;

    public TelefoneController(TelefoneRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<TelefoneDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDto> getById(@PathVariable int id) {
        return repository.findById(id).map(t -> ResponseEntity.ok(toDto(t))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TelefoneDto> create(@RequestBody TelefoneDto dto) {
        TelefoneModel m = toEntity(dto);
        TelefoneModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/telefones/" + saved.getIdTelefone())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDto> update(@PathVariable int id, @RequestBody TelefoneDto dto) {
        TelefoneModel m = toEntity(dto);
        m.setIdTelefone(id);
        TelefoneModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private TelefoneDto toDto(TelefoneModel m) {
        Integer usuarioId = m.getUsuario() != null ? m.getUsuario().getIdUsuario() : null;
        return new TelefoneDto(m.getIdTelefone(), usuarioId, m.getNumero());
    }

    private TelefoneModel toEntity(TelefoneDto d) {
        TelefoneModel m = new TelefoneModel();
        if (d.idTelefone() != null) m.setIdTelefone(d.idTelefone());
        m.setNumero(d.numero());
        if (d.usuarioId() != null) usuarioRepository.findById(d.usuarioId()).ifPresent(m::setUsuario);
        return m;
    }
}

