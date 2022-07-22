package com.filmes.filmes.dto.categoria;

import com.filmes.filmes.errors.ApiMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequestDTO {
    String nome;
}
