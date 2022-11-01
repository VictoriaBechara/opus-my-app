package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.domain.Platform;
import com.vick.myappfinal.dtos.PlatformDTO;
import com.vick.myappfinal.repositories.PlatformRepository;
import com.vick.myappfinal.service.exceptions.DataIntegrityViolationException;
import com.vick.myappfinal.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformServiceImpl {

    @Autowired
    private PlatformRepository platformRepository;

    private final GameServiceImpl gameService;

    @Autowired
    public PlatformServiceImpl(@Lazy GameServiceImpl gameService){
        this.gameService = gameService;
    }

    public Platform findById(Integer id) {
        Optional<Platform> obj = platformRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Platform.class.getName()));
    }

    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    public Platform create(Platform obj) {
        obj.setPlatformId(null);
        return platformRepository.save(obj);
    }

    public Platform update(Integer id, PlatformDTO objDto) {
        Platform obj = findById(id);
        obj.setPlatformId(objDto.getPlatformId());
        obj.setPlatformName(objDto.getPlatformName());

        return platformRepository.save(obj);
    }

    public void delete(Integer id) {
        Platform obj = findById(id);
        platformRepository.delete(obj);
    }

    public Platform addGameToPlatformById(Integer gameId, Integer platformId) {
        Platform list = platformRepository.findById(platformId).orElseThrow(() -> new ObjectNotFoundException("Platform not found!"));

        list.getGames().add(gameService.findById(gameId));
        platformRepository.save(list);

        return list;
    }
}
