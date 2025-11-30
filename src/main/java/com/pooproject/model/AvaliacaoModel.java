package com.pooproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "avaliacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAvaliacao;

    private String comentario;
    private Double nota;
    private LocalDateTime dataAvaliacao;
}
