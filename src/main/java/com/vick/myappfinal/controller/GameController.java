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
@RequestMapping(value = "/game")
public class GameController {
    private final GameServiceImpl gameServiceImpl;

    public GameController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable Integer id) {
        Game obj = gameServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll(@RequestParam(value = "platform", defaultValue = "0") Integer platformId) {
        List<Game> list = gameServiceImpl.findAll(platformId);
        List<GameDTO> listDTO = list.stream().map(GameDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/create")
    public ResponseEntity<Game> create(@Valid @RequestBody Game obj) {
        obj = gameServiceImpl.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getGameId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Game> update(@PathVariable Integer id, @RequestBody Game obj) {
        Game newObj = gameServiceImpl.update(id, obj);
        return ResponseEntity.ok().body(newObj);

    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        gameServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }


}
