package com.pooproject.dto;

import java.time.LocalDateTime;

public record UsuarioDto(
        Integer idUsuario,
        String primeiroNome,
        String ultimoNome,
        String cpf,
        String senha,
        LocalDateTime dataNascimento
) {
}

