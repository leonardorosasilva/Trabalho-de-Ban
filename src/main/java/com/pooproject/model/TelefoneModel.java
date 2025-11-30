package com.pooproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "telefone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idTelefone;

    // id usuario
    @Column(nullable = false)
    @JoinColumn(name = "idUsuario")
    private int idUsuario;

    @OneToMany
    @Column(nullable = false)
    private String numero;
}
