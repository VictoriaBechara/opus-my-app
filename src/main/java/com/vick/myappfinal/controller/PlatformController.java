package com.vick.myappfinal.controller;

import com.vick.myappfinal.domain.Platform;
import com.vick.myappfinal.dtos.PlatformDTO;
import com.vick.myappfinal.service.PlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/platform")
public class PlatformController {
    private final PlatformServiceImpl platformServiceImpl;

    public PlatformController(PlatformServiceImpl platformServiceImpl) {
        this.platformServiceImpl = platformServiceImpl;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Platform> findById(@PathVariable Integer id) {
        Platform obj = platformServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<PlatformDTO>> findAll() {
        List<Platform> list = platformServiceImpl.findAll();
        List<PlatformDTO> listDTO = list.stream().map(obj -> new PlatformDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/create")
    public ResponseEntity<Platform> create(@RequestBody Platform obj) {
        obj = platformServiceImpl.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getPlatformId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping(value = "/update{id}")
    public ResponseEntity<PlatformDTO> update(@PathVariable Integer id, @RequestBody PlatformDTO objDto) {
        Platform newObj = platformServiceImpl.update(id, objDto);
        return ResponseEntity.ok().body(new PlatformDTO(newObj));
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        platformServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    //@CrossOrigin("http://localhost:4200")
    //@PostMapping(value = "/addGameToPlatform/{gameId}/{platformId}")
    //public ResponseEntity<Platform> addGameToPlatformById(@PathVariable Integer gameId, @PathVariable Integer platformId) {
        //Platform list = platformServiceImpl.addGameToPlatformById(gameId, platformId);
        //return ResponseEntity.ok().body(list);
    //}
}