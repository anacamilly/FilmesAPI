package com.filmes.filmes.controllers;

import com.filmes.filmes.domain.Filmes;
import com.filmes.filmes.dto.filmes.FilmesRequestDTO;
import com.filmes.filmes.dto.filmes.FilmesResponseDTO;
import com.filmes.filmes.service.FilmesService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*")
public class FilmesController {
    FilmesService service;
    ModelMapper modelMapper = new ModelMapper();

    public FilmesController(FilmesService service){
        this.service = service;
    }

    @GetMapping
    public List<Filmes> relatorioFilmes(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<FilmesResponseDTO> findById(@PathVariable Integer id){
        Optional<Filmes> f  = service.findById(id);
        if (f.isPresent()){
            Filmes filmes = f.get();
            FilmesResponseDTO filmesResponseDto = modelMapper.map(filmes, FilmesResponseDTO.class);
            filmesResponseDto.addHateoasLinks(filmes.getId());
            return ResponseEntity.ok().body(filmesResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Filmes> insert(@RequestBody FilmesRequestDTO f) throws URISyntaxException {

        Filmes novo = modelMapper.map(f, Filmes.class);

        service.create(novo);

        URI uri = new URI("/filmes/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filmes> update (@PathVariable Integer id, @RequestBody Filmes f){
        if (service.findById(id).isPresent()){
            Filmes atualizado = service.update(f);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id ){
        if (service.findById(id).isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
