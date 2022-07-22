package com.filmes.filmes.controllers;

import com.filmes.filmes.domain.Sinopse;
import com.filmes.filmes.dto.sinopse.SinopseRequestDTO;
import com.filmes.filmes.dto.sinopse.SinopseResponseDTO;
import com.filmes.filmes.service.SinopseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sinopse")
@CrossOrigin(origins = "*")
public class SinopseController {

    SinopseService service;
    ModelMapper modelMapper = new ModelMapper();

    public SinopseController(SinopseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sinopse> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<SinopseResponseDTO> findById(@PathVariable Integer id){
        Optional<Sinopse> s  = service.findById(id);
        if (s.isPresent()){
            Sinopse sinopse = s.get();
            SinopseResponseDTO etiquetaResponseDto = modelMapper.map(sinopse, SinopseResponseDTO.class);
            etiquetaResponseDto.addHateoasLinks(sinopse.getId());
            return ResponseEntity.ok().body(etiquetaResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Sinopse> insert(@RequestBody SinopseRequestDTO s) throws URISyntaxException {


        Sinopse novo = modelMapper.map(s, Sinopse.class);

        service.create(novo);

        URI uri = new URI("/sinopse/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinopse> update (@PathVariable Integer id, @RequestBody Sinopse s){
        if (service.findById(id).isPresent()){
            Sinopse atualizado = service.update(s);
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
