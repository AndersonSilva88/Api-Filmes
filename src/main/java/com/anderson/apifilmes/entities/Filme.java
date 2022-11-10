package com.anderson.apifilmes.entities;

import java.util.Date;

public class Filme {

    private Integer id;
    private String nome;
    private String nomeDiretor;
    private Integer ano;
    private Integer nota;


    public Filme(Integer id, String nome, String nomeDiretor, Integer ano, Integer nota) {
        this.id = id;
        this.nome = nome;
        this.nomeDiretor = nomeDiretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
