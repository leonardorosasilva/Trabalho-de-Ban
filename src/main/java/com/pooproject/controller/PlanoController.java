package com.pooproject.controller;

import com.pooproject.dto.PlanoDto;
import com.pooproject.model.PlanoModel;
import com.pooproject.repository.PlanoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/planos")
public class PlanoController {
    private final PlanoRepository repository;

    public PlanoController(PlanoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PlanoDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDto> getById(@PathVariable int id) {
        return repository.findById(id).map(p -> ResponseEntity.ok(toDto(p))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlanoDto> create(@RequestBody PlanoDto dto) {
        PlanoModel m = toEntity(dto);
        PlanoModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/planos/" + saved.getIdPlano())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDto> update(@PathVariable int id, @RequestBody PlanoDto dto) {
        PlanoModel m = toEntity(dto);
        m.setIdPlano(id);
        PlanoModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private PlanoDto toDto(PlanoModel m) {
        return new PlanoDto(m.getIdPlano(), m.getNome(), m.getPreco(), m.getLimite_telas(), m.getPeriodicidade());
    }

    private PlanoModel toEntity(PlanoDto d) {
        PlanoModel m = new PlanoModel();
        if (d.idPlano() != null) m.setIdPlano(d.idPlano());
        m.setNome(d.nome());
        m.setPreco(d.preco() != null ? d.preco() : 0);
        m.setLimite_telas(d.limiteTelas() != null ? d.limiteTelas() : 0);
        m.setPeriodicidade(d.periodicidade());
        return m;
    }
}

