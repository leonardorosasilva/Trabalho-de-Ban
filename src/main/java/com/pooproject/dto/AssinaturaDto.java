package com.pooproject.dto;

import java.time.LocalDateTime;

public record AssinaturaDto(
        Integer idAssinatura,
        LocalDateTime inicio,
        LocalDateTime fim,
        String status,
        Integer planoId,
        Integer usuarioId,
        Integer conteudoId
) {}

