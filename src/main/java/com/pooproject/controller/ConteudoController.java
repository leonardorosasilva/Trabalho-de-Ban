package com.pooproject.controller;

import com.pooproject.dto.ConteudoDto;
import com.pooproject.model.ConteudoModel;
import com.pooproject.model.AdministradorModel;
import com.pooproject.repository.ConteudoRepository;
import com.pooproject.repository.AdministradorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {
    private final ConteudoRepository repository;
    private final AdministradorRepository administradorRepository;

    public ConteudoController(ConteudoRepository repository, AdministradorRepository administradorRepository) {
        this.repository = repository;
        this.administradorRepository = administradorRepository;
    }

    @GetMapping
    public List<ConteudoDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConteudoDto> getById(@PathVariable int id) {
        return repository.findById(id).map(c -> ResponseEntity.ok(toDto(c))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConteudoDto> create(@RequestBody ConteudoDto dto) {
        ConteudoModel m = toEntity(dto);
        ConteudoModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/conteudos/" + saved.getIdConteudo())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConteudoDto> update(@PathVariable int id, @RequestBody ConteudoDto dto) {
        ConteudoModel m = toEntity(dto);
        m.setIdConteudo(id);
        ConteudoModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ConteudoDto toDto(ConteudoModel m) {
        Integer adminId = m.getAdministrador() != null ? m.getAdministrador().getIdUsuario() : null;
        return new ConteudoDto(m.getIdConteudo(), m.getTitulo(), m.getAnoLancamento(), m.getClassificacao(), m.getSinopse(), adminId);
    }

    private ConteudoModel toEntity(ConteudoDto d) {
        ConteudoModel m = new ConteudoModel();

        if (d.idConteudo() != null)
            m.setIdConteudo(d.idConteudo());

        m.setTitulo(d.titulo());
        m.setAnoLancamento(d.anoLancamento());
        m.setClassificacao(d.classificacao());
        m.setSinopse(d.sinopse());

        // ⛔ ANTES: ifPresent → não garantia admin
        // ✅ AGORA: Obrigatório e com erro claro
        AdministradorModel admin = administradorRepository
                .findById(d.administradorId())
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado"));

        m.setAdministrador(admin);

        return m;
    }
}

