package com.pooproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel extends UsuarioModel{

    @OneToOne
    @JoinColumn(name = "idAssinatura")
    private AssinaturaModel assinatura;

    @OneToOne
    @JoinColumn(name = "idAvaliacao")
    private AvaliacaoModel avaliacao;
}
