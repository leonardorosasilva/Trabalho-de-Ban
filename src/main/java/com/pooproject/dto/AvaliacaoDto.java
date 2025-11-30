package com.pooproject.dto;

import java.time.LocalDateTime;

public record AvaliacaoDto(
        Integer idAvaliacao,
        String comentario,
        Double nota,
        LocalDateTime dataAvaliacao
) {}

