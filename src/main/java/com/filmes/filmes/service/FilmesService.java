package com.filmes.filmes.service;

import com.filmes.filmes.domain.Filmes;
import com.filmes.filmes.domain.Sinopse;
import com.filmes.filmes.repository.FilmesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    private final FilmesRepository repository;

    public FilmesService(FilmesRepository repository) {
        this.repository = repository;
    }

    public Filmes create(Filmes f){
        return repository.save(f);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Filmes update(Filmes f){
        return repository.saveAndFlush(f);
    }

    public Optional<Filmes> findById(Integer id){
        return repository.findById(id);
    }


    public List<Filmes> findAll(){
        return repository.findAll();
    }
}