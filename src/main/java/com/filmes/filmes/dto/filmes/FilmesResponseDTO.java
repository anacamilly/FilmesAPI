package com.filmes.filmes.dto.filmes;

import com.filmes.filmes.controllers.FilmesController;
import com.filmes.filmes.domain.Categoria;
import com.filmes.filmes.domain.Sinopse;
import com.filmes.filmes.errors.ApiMessages;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class FilmesResponseDTO extends RepresentationModel<FilmesResponseDTO> {

    String titulo;

    String diretor;

    String lancamento;

    String preco;

    Integer avaliacao;

    public void addHateoasLinks(Integer id ) {
        this.add(linkTo(FilmesController.class).slash(id).withSelfRel());
        this.add(linkTo(FilmesController.class).withRel("GET"));
        this.add(linkTo(FilmesController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(FilmesController.class).slash(id).withRel("PUT"));
        this.add(linkTo(FilmesController.class).withRel("POST"));
    }
}
