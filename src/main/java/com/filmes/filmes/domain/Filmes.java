package com.filmes.filmes.domain;

import com.filmes.filmes.errors.ApiMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = ApiMessages.ERRO_TITULO)
    @Size(min = 5)
    String titulo;

    @NotBlank(message = ApiMessages.ERRO_DIRETOR)
    @Size(min = 5)
    String diretor;

    @NotBlank(message = ApiMessages.ERRO_LANCAMENTO)
    String lancamento;

    @NotBlank(message = ApiMessages.ERRO_PRECO)
    String preco;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "sinopse_id")
    Sinopse sinopse;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "categoria_id")
    Categoria categoria;

    Integer avaliacao;

}