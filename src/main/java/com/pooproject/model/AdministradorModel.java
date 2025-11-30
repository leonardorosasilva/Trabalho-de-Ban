package com.pooproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(nullable = false)
    private String credencial;
}
