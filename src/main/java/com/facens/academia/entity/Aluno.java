package com.facens.academia.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Integer idade;
    private String telefone;
    private String situacao;

    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    // Construtor vazio (obrigatório)
    public Aluno() {
    }

    // Preencher data automaticamente antes de salvar
    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
    }

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}