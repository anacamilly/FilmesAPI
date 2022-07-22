package com.filmes.filmes.dto.filmes;

import com.filmes.filmes.domain.Categoria;
import com.filmes.filmes.domain.Sinopse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmesRequestDTO {
    String titulo;

    String diretor;

    String lancamento;

    String preco;

    Sinopse sinopse;

    Categoria categoria;

    Integer avaliacao;

}
