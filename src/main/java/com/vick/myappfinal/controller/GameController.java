package com.vick.myappfinal.controller;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.dtos.GameDTO;
import com.vick.myappfinal.service.GameService;
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
    @Autowired
    private GameService gameServiceImpl;

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable Integer id) {
        Game obj = gameServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/findByName/{gameName}")
    public ResponseEntity<Game> findByName(@PathVariable String gameName) {
        Game obj = gameServiceImpl.findByName(gameName);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/all")
    public ResponseEntity<List<GameDTO>> findAllGames() {
        List<Game> list = gameServiceImpl.findAllGames();
        List<GameDTO> listDTO = list.stream().map(obj -> new GameDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll(@RequestParam(value = "platform", defaultValue = "0") Integer platformId) {
        List<Game> list = gameServiceImpl.findAll(platformId);
        List<GameDTO> listDTO = list.stream().map(GameDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping
    public  ResponseEntity<Game> create(@Valid @RequestBody Game obj){
        obj = gameServiceImpl.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(obj.getGameId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping(value = "/{id}")
    public ResponseEntity<GameDTO> update(@PathVariable Integer id, @RequestBody Game objDto){
        Game newObj = gameServiceImpl.update(id, objDto);
        return ResponseEntity.ok().body(new GameDTO(newObj));

    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        gameServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping(value = "/removeGameAtPlatform/{platformId}/{gameId}")
    public ResponseEntity<Void> remove(@PathVariable Integer platformId, @PathVariable Integer gameId){
        gameServiceImpl.remove(platformId, gameId);
        return  ResponseEntity.noContent().build();
    }
}
