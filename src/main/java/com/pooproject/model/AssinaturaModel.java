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

    @ManyToOne
    @JoinColumn(name = "idPlano", nullable = false)
    private PlanoModel plano;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idConteudo", nullable = false)
    private ConteudoModel conteudo;
}
