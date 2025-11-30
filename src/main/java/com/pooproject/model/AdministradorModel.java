package com.pooproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "administrador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorModel extends UsuarioModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idAdministrador;

    @Column(nullable = false)
    private String credencial;
}
