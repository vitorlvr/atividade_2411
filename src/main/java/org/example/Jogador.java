package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String funcao;
    @Column
    private String nomeTime;
    @Column
    private String patente;

    public Jogador(String nome, String funcao, String nomeTime, String patente) {
        this.nome = nome;
        this.funcao = funcao;
        this.nomeTime = nomeTime;
        this.patente = patente;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getPatente() {
        return patente;
    }
}