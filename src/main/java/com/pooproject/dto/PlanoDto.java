package com.pooproject.dto;

public record PlanoDto(
        Integer idPlano,
        String nome,
        Double preco,
        Integer limiteTelas,
        String periodicidade
) {}

