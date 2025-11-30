package com.pooproject.controller;

import com.pooproject.dto.AdministradorDto;
import com.pooproject.model.AdministradorModel;
import com.pooproject.model.UsuarioModel;
import com.pooproject.repository.AdministradorRepository;
import com.pooproject.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {
    private final AdministradorRepository repository;
    private final UsuarioRepository usuarioRepository;

    public AdministradorController(AdministradorRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<AdministradorDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDto> getById(@PathVariable int id) {
        return repository.findById(id).map(a -> ResponseEntity.ok(toDto(a))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdministradorDto> create(@RequestBody AdministradorDto dto) {
        AdministradorModel m = toEntity(dto);
        AdministradorModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/administradores/" + saved.getIdUsuario())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDto> update(@PathVariable int id, @RequestBody AdministradorDto dto) {
        AdministradorModel m = toEntity(dto);
        m.setIdUsuario(id);
        AdministradorModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private AdministradorDto toDto(AdministradorModel m) {
        return new AdministradorDto(m.getIdUsuario(), m.getPrimeiro_nome(), m.getUltimo_nome(), m.getCpf(), m.getSenha(), m.getCredencial());
    }

    private AdministradorModel toEntity(AdministradorDto d) {
        AdministradorModel m = new AdministradorModel();
        if (d.idUsuario() != null) m.setIdUsuario(d.idUsuario());
        m.setPrimeiro_nome(d.primeiroNome());
        m.setUltimo_nome(d.ultimoNome());
        m.setCpf(d.cpf());
        m.setSenha(d.senha());
        m.setCredencial(d.credencial());
        return m;
    }
}

