package com.vick.myappfinal.controller;

import com.vick.myappfinal.domain.Genre;
import com.vick.myappfinal.dtos.GenreDTO;
import com.vick.myappfinal.service.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/gameCollection")
public class GenreController {
    @Autowired
    private GenreServiceImpl genreServiceImpl;

    @GetMapping(value = "/genreList/{id}")
    public ResponseEntity<Genre> findById(@PathVariable Integer id){
        Genre obj = genreServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/genreList")
    public ResponseEntity<List<GenreDTO>> findAll(){
        List<Genre> list = genreServiceImpl.findAll();
        List<GenreDTO> listDTO = list.stream().map(obj -> new GenreDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping(value = "/createGenre")
    public ResponseEntity<Genre> create(@RequestBody Genre obj){
        obj = genreServiceImpl.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getGenreId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/updateGenre/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable Integer id, @RequestBody GenreDTO genreDTO){
        Genre newObj = genreServiceImpl.update(id, genreDTO);
        return ResponseEntity.ok().body(new GenreDTO(newObj));
    }

    @DeleteMapping(value = "/deleteGenre/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        genreServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/addGameToGenre/{gameId}/{genreId}")
    public ResponseEntity<Genre> addGameToPlatformById(@PathVariable Integer gameId, @PathVariable Integer genreId){
        Genre list = genreServiceImpl.addGameToGenreById(gameId, genreId);
        return ResponseEntity.ok().body(list);
    }
}
