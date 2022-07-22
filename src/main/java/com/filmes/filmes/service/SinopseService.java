package com.filmes.filmes.service;

import com.filmes.filmes.domain.Sinopse;
import com.filmes.filmes.repository.SinopseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinopseService {
    SinopseRepository repository;

    public SinopseService(SinopseRepository repository) {
        this.repository = repository;
    }

    public Sinopse create(Sinopse s){
        return repository.save(s);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Sinopse update(Sinopse s){
        return repository.saveAndFlush(s);
    }

    public Optional<Sinopse> findById(Integer id){
        return repository.findById(id);
    }

    public List<Sinopse> findAll(){
        return repository.findAll();
    }
}
