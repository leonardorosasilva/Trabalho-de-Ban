package com.pooproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idUsuario;

    @Column(nullable = false)
    private String primeiro_nome;
    @Column(nullable = false)
    private String ultimo_nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String senha;

    @Column(nullable = true)
    private LocalDateTime data_nascimento;
}
