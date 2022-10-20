package com.vick.myappfinal.controller;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.dtos.GameDTO;
import com.vick.myappfinal.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping
public class GameController {

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/game/{id}")
    public ResponseEntity<Game> findById(@PathVariable Integer id) {
        Game obj = gameServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/game")
    public ResponseEntity<List<GameDTO>> findAll() {
        List<Game> list = gameServiceImpl.findAll();
        List<GameDTO> listDTO = list.stream().map(obj -> new GameDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/createGame")
    public ResponseEntity<Game> create(@Valid @RequestBody Game obj) {
        obj = gameServiceImpl.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(obj.getGameId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping(value = "/updateGame/{id}")
    public ResponseEntity<GameDTO> update(@PathVariable Integer id, @RequestBody GameDTO objDto) {
        Game newObj = gameServiceImpl.update(id, objDto);
        return ResponseEntity.ok().body(new GameDTO(newObj));

    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping(value = "/deleteGameById/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        gameServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }


}
