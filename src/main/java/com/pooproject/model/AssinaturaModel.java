package com.pooproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "assinatura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idAssinatura;

    @Column(nullable = false)
    private LocalDateTime inicio;

    private LocalDateTime fim;

    private String status;

    @OneToOne
    @JoinColumn(name = "idPlano", nullable = false)
    private PlanoModel plano;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
}
