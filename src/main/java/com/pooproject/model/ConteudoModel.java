package com.pooproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "conteudo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idConteudo;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int anoLancamento;

    @Column(nullable = false)
    private String classificacao;

    @Column(nullable = false)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private AdministradorModel administrador;

    @OneToMany(mappedBy = "conteudo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssinaturaModel> assinatura = new ArrayList<>();
}
