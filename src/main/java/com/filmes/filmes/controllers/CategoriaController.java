package com.filmes.filmes.controllers;

import com.filmes.filmes.domain.Categoria;
import com.filmes.filmes.dto.categoria.CategoriaRequestDTO;
import com.filmes.filmes.dto.categoria.CategoriaResponseDTO;
import com.filmes.filmes.service.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {
    CategoriaService service;
    ModelMapper modelMapper = new ModelMapper();

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CategoriaResponseDTO> findById(@PathVariable Integer id){
        Optional<Categoria> c  = service.findById(id);
        if (c.isPresent()){
            Categoria categoria = c.get();
            CategoriaResponseDTO categoriaResponseDto = modelMapper.map(categoria, CategoriaResponseDTO.class);
            categoriaResponseDto.addHateoasLinks(categoria.getId());
            return ResponseEntity.ok().body(categoriaResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody CategoriaRequestDTO c) throws URISyntaxException {


        Categoria novo = modelMapper.map(c, Categoria.class);

        service.create(novo);

        URI uri = new URI("/categoria/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update (@PathVariable Integer id, @RequestBody Categoria c){
        if (service.findById(id).isPresent()){
            Categoria atualizado = service.update(c);
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
