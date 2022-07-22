package com.filmes.filmes.repository;

import com.filmes.filmes.domain.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filmes, Integer> {
}