package com.anderson.apifilmes.service;

import com.anderson.apifilmes.entities.Filme;
import com.anderson.apifilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService implements IFilmeService{

    private final List<Filme> filmes;
    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeService() {
        this.filmes = new ArrayList<>();
    }

    @Override
    public List<Filme> findAll(String nome) {
        if (nome != null) {
            return filmeRepository.findAll(nome);
        } else if(filmeRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return filmeRepository.findAll();
    }

    @Override
    public Filme findById(Integer id) {
        if (id != null) {
            return filmeRepository.findById(id);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Integer add(Filme filme) {
        if (filme.getId() == null){
            filme.setId(filmeRepository.count() + 1);
        }
        if (filme.getNota() < 1 || filme.getNota() > 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (filmeRepository.findAll().stream().anyMatch(f -> f.getNome().equalsIgnoreCase(filme.getNome()))){
            if (filmeRepository.findAll().stream().anyMatch(f -> f.getNomeDiretor().equalsIgnoreCase(filme.getNomeDiretor()))){
                if (filmeRepository.findAll().stream().anyMatch(f -> f.getAno().equals(filme.getAno()))) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
            }
        }
        filmeRepository.add(filme);
        return filme.getId();
    }

    @Override
    public void update(Filme filme) {
        if (filme.getNota() >= 1 || filme.getNota() <= 5) {
            filmeRepository.update(filme);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public void delete(Integer id) {
        filmeRepository.delete(id);
    }
}
