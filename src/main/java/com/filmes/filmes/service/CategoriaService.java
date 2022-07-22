package com.filmes.filmes.service;

import com.filmes.filmes.domain.Categoria;
import com.filmes.filmes.domain.Sinopse;
import com.filmes.filmes.repository.CategoriaRepository;
import com.filmes.filmes.repository.SinopseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria create(Categoria c){
        return repository.save(c);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Categoria update(Categoria c){
        return repository.saveAndFlush(c);
    }

    public Optional<Categoria> findById(Integer id){
        return repository.findById(id);
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }
}
