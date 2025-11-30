package com.pooproject.controller;

import com.pooproject.dto.ClienteDto;
import com.pooproject.model.AssinaturaModel;
import com.pooproject.model.AvaliacaoModel;
import com.pooproject.model.ClienteModel;
import com.pooproject.model.UsuarioModel;
import com.pooproject.repository.AssinaturaRepository;
import com.pooproject.repository.AvaliacaoRepository;
import com.pooproject.repository.ClienteRepository;
import com.pooproject.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository repository;
    private final AssinaturaRepository assinaturaRepo;
    private final AvaliacaoRepository avaliacaoRepo;
    private final UsuarioRepository usuarioRepo;

    public ClienteController(ClienteRepository repository,
                             AssinaturaRepository assinaturaRepo,
                             AvaliacaoRepository avaliacaoRepo,
                             UsuarioRepository usuarioRepo) {
        this.repository = repository;
        this.assinaturaRepo = assinaturaRepo;
        this.avaliacaoRepo = avaliacaoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public List<ClienteDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable int id) {
        return repository.findById(id).map(c -> ResponseEntity.ok(toDto(c))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto dto) {
        ClienteModel m = toEntity(dto);
        ClienteModel saved = repository.save(m);
        return ResponseEntity.created(URI.create("/clientes/" + saved.getIdUsuario())).body(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable int id, @RequestBody ClienteDto dto) {
        ClienteModel m = toEntity(dto);
        m.setIdUsuario(id);
        ClienteModel updated = repository.save(m);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ClienteDto toDto(ClienteModel m) {
        Integer assinaturaId = m.getAssinatura() != null ? m.getAssinatura().getIdAssinatura() : null;
        Integer avaliacaoId = m.getAvaliacao() != null ? m.getAvaliacao().getIdAvaliacao() : null;
        return new ClienteDto(m.getIdUsuario(), m.getPrimeiro_nome(), m.getUltimo_nome(), m.getCpf(), m.getSenha(), m.getData_nascimento(), assinaturaId, avaliacaoId);
    }

    private ClienteModel toEntity(ClienteDto d) {
        ClienteModel m = new ClienteModel();
        if (d.idUsuario() != null) m.setIdUsuario(d.idUsuario());
        m.setPrimeiro_nome(d.primeiroNome());
        m.setUltimo_nome(d.ultimoNome());
        m.setCpf(d.cpf());
        m.setSenha(d.senha());
        m.setData_nascimento(d.dataNascimento());
        if (d.idAssinatura() != null) assinaturaRepo.findById(d.idAssinatura()).ifPresent(m::setAssinatura);
        if (d.idAvaliacao() != null) avaliacaoRepo.findById(d.idAvaliacao()).ifPresent(m::setAvaliacao);
        return m;
    }
}

