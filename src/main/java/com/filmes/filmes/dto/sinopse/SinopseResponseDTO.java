package com.filmes.filmes.dto.sinopse;

import com.filmes.filmes.controllers.FilmesController;
import com.filmes.filmes.dto.filmes.FilmesResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class SinopseResponseDTO extends RepresentationModel<FilmesResponseDTO> {
    String sinopse;

    public void addHateoasLinks(Integer id ) {
        this.add(linkTo(FilmesController.class).withRel("GET"));
        this.add(linkTo(FilmesController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(FilmesController.class).slash(id).withRel("PUT"));
        this.add(linkTo(FilmesController.class).withRel("POST"));
    }
}
