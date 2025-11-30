package com.pooproject.dto;

public record AdministradorDto(
        Integer idUsuario,
        String primeiroNome,
        String ultimoNome,
        String cpf,
        String senha,
        String credencial
) {}

