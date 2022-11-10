package com.anderson.apifilmes.repository;

import com.anderson.apifilmes.entities.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmeRepository{

    private final List<Filme> filmes;

    public FilmeRepository() {
        this.filmes = new ArrayList<>();
    }

    public List<Filme> findAll() {
        return filmes;
    }

    public List<Filme> findAll(String nome) {
        return filmes.stream()
                .filter(fil -> fil.getNome().contains(nome))
                .collect(Collectors.toList());
    }

    public Filme findById(Integer id) {
        return this.filmes.stream()
                .filter(fil -> fil.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void add(Filme filme) {
        this.filmes.add(filme);
    }

    public void update(Filme filme) {
        Filme filmeUpdate = filmes.stream()
                .filter(fil -> fil.getId().equals(filme.getId()))
                .findFirst()
                .orElse(null);
        assert filmeUpdate != null;
        filmeUpdate.setNome(filme.getNome());
        filmeUpdate.setNomeDiretor(filme.getNomeDiretor());
        filmeUpdate.setAno(filme.getAno());
        filmeUpdate.setNota(filme.getNota());
    }

    public void delete(Integer id) {
        filmes.removeIf(fil -> fil.getId().equals(id));
    }

    public int count() {
        return filmes.size();
    }

}
