package com.pooproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int idUsuario;

    @Column(Nullable = false)
    private String primeiro_nome;
    @Column(Nullable = false)
    private String ultimo_nome;
    @Column(Nullable = false)
    private String cpf;
    @Column(Nullable = false)
    private String senha;

    @Column(Nullable = true)
    private LocalDateTime data_nascimento;
}
