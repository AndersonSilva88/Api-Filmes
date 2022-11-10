package com.anderson.apifilmes.service;

import com.anderson.apifilmes.entities.Filme;

import java.util.List;

public interface IFilmeService {

    List<Filme> findAll(String filme);
    Filme findById(Integer id);
    Integer add(Filme filme);
    void update(Filme filme);
    void delete(Integer id);
}
