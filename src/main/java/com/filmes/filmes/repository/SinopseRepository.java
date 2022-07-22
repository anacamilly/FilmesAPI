package com.filmes.filmes.repository;

import com.filmes.filmes.domain.Sinopse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinopseRepository  extends JpaRepository<Sinopse, Integer> {
}
