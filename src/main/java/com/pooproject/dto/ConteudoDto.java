package com.pooproject.dto;

public record ConteudoDto(
        Integer idConteudo,
        String titulo,
        Integer anoLancamento,
        String classificacao,
        String sinopse,
        Integer administradorId
) {}

