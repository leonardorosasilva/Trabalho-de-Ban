package com.pooproject.controller;

import com.pooproject.dto.UsuarioDto;
import com.pooproject.model.UsuarioModel;
import com.pooproject.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioDto> getAll() {
        return service.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable int id) {
        return service.findById(id).map(u -> ResponseEntity.ok(toDto(u))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto dto) {
        UsuarioModel saved = service.create(toEntity(dto));
        return ResponseEntity.created(URI.create("/usuarios/" + saved.getIdUsuario())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable int id, @RequestBody UsuarioDto dto) {
        UsuarioModel updated = service.update(id, toEntity(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private UsuarioDto toDto(UsuarioModel m) {
        return new UsuarioDto(m.getIdUsuario(), m.getPrimeiro_nome(), m.getUltimo_nome(), m.getCpf(), m.getSenha(), m.getData_nascimento());
    }

    private UsuarioModel toEntity(UsuarioDto d) {
        UsuarioModel m = new UsuarioModel();
        if (d.idUsuario() != null) m.setIdUsuario(d.idUsuario());
        m.setPrimeiro_nome(d.primeiroNome());
        m.setUltimo_nome(d.ultimoNome());
        m.setCpf(d.cpf());
        m.setSenha(d.senha());
        m.setData_nascimento(d.dataNascimento());
        return m;
    }
}

