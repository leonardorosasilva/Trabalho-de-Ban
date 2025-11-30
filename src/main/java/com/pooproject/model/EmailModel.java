package com.pooproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idEmail;

    // id usuario
    @JoinColumn(name = "idUsuario", nullable = false)
    private int idUsuario;

    @Column(nullable = false)
    private String email;
}
