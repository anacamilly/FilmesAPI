package com.filmes.filmes.dto.categoria;

import com.filmes.filmes.controllers.FilmesController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class CategoriaResponseDTO extends RepresentationModel<CategoriaResponseDTO> {
    String nome;

    public void addHateoasLinks(Integer id ) {
        this.add(linkTo(FilmesController.class).withRel("GET"));
        this.add(linkTo(FilmesController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(FilmesController.class).slash(id).withRel("PUT"));
        this.add(linkTo(FilmesController.class).withRel("POST"));
    }
}
