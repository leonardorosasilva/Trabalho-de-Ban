package com.pooproject.controller;

import com.pooproject.dto.AvaliacaoDto;
import com.pooproject.model.AvaliacaoModel;
import com.pooproject.repository.AvaliacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    private final AvaliacaoRepository repository;

    public AvaliacaoController(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AvaliacaoDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDto> getById(@PathVariable int id) {
        return repository.findById(id).map(a -> ResponseEntity.ok(toDto(a))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDto> create(@RequestBody AvaliacaoDto dto) {
        AvaliacaoModel m = toEntity(dto);
        AvaliacaoModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/avaliacoes/" + saved.getIdAvaliacao())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoDto> update(@PathVariable int id, @RequestBody AvaliacaoDto dto) {
        AvaliacaoModel m = toEntity(dto);
        m.setIdAvaliacao(id);
        AvaliacaoModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private AvaliacaoDto toDto(AvaliacaoModel m) {
        return new AvaliacaoDto(m.getIdAvaliacao(), m.getComentario(), m.getNota(), m.getDataAvaliacao());
    }

    private AvaliacaoModel toEntity(AvaliacaoDto d) {
        AvaliacaoModel m = new AvaliacaoModel();
        if (d.idAvaliacao() != null) m.setIdAvaliacao(d.idAvaliacao());
        m.setComentario(d.comentario());
        m.setNota(d.nota());
        m.setDataAvaliacao(d.dataAvaliacao());
        return m;
    }
}

