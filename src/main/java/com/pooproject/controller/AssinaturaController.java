package com.pooproject.controller;

import com.pooproject.dto.AssinaturaDto;
import com.pooproject.model.AssinaturaModel;
import com.pooproject.model.PlanoModel;
import com.pooproject.model.UsuarioModel;
import com.pooproject.repository.AssinaturaRepository;
import com.pooproject.repository.PlanoRepository;
import com.pooproject.repository.UsuarioRepository;
import com.pooproject.repository.ConteudoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {
    private final AssinaturaRepository repository;
    private final PlanoRepository planoRepo;
    private final UsuarioRepository usuarioRepo;
    private final ConteudoRepository conteudoRepo;

    public AssinaturaController(AssinaturaRepository repository, PlanoRepository planoRepo, UsuarioRepository usuarioRepo, ConteudoRepository conteudoRepo) {
        this.repository = repository;
        this.planoRepo = planoRepo;
        this.usuarioRepo = usuarioRepo;
        this.conteudoRepo = conteudoRepo;
    }

    @GetMapping
    public List<AssinaturaDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssinaturaDto> getById(@PathVariable int id) {
        return repository.findById(id).map(a -> ResponseEntity.ok(toDto(a))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AssinaturaDto> create(@RequestBody AssinaturaDto dto) {
        AssinaturaModel m = toEntity(dto);
        AssinaturaModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/assinaturas/" + saved.getIdAssinatura())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssinaturaDto> update(@PathVariable int id, @RequestBody AssinaturaDto dto) {
        AssinaturaModel m = toEntity(dto);
        m.setIdAssinatura(id);
        AssinaturaModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private AssinaturaDto toDto(AssinaturaModel m) {
        Integer planoId = m.getPlano() != null ? m.getPlano().getIdPlano() : null;
        Integer usuarioId = m.getUsuario() != null ? m.getUsuario().getIdUsuario() : null;
        Integer conteudoId = m.getConteudo() != null ? m.getConteudo().getIdConteudo() : null;
        return new AssinaturaDto(m.getIdAssinatura(), m.getInicio(), m.getFim(), m.getStatus(), planoId, usuarioId, conteudoId);
    }

    private AssinaturaModel toEntity(AssinaturaDto d) {
        AssinaturaModel m = new AssinaturaModel();

        if (d.idAssinatura() != null)
            m.setIdAssinatura(d.idAssinatura());

        m.setInicio(d.inicio());
        m.setFim(d.fim());
        m.setStatus(d.status());

        // Agora sempre seta as FKs (mesmo sem buscar do banco antes)
        m.setPlano(planoRepo.getReferenceById(d.planoId()));
        m.setUsuario(usuarioRepo.getReferenceById(d.usuarioId()));
        m.setConteudo(conteudoRepo.getReferenceById(d.conteudoId()));

        return m;
    }
}

