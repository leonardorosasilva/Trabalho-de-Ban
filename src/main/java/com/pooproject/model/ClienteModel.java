package com.pooproject.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class ClienteModel extends  UsuarioModel{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idUsuario;
}
