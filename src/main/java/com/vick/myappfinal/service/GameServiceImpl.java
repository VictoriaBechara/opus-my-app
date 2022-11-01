package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.domain.Platform;
import com.vick.myappfinal.repositories.GameRepository;
import com.vick.myappfinal.repositories.PlatformRepository;
import com.vick.myappfinal.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private  PlatformServiceImpl platformService;

    @Autowired
    private PlatformRepository platformRepository;

    //@Autowired
    //private GenreServiceImpl genreService;

    public Game findById(Integer id) {
        Optional<Game> obj = gameRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Game.class.getName()));
    }

    public Game findByName(String gameName) {
        Optional<Game> obj = gameRepository.findByGameName(gameName);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Name: " + Game.class.getName()));
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public List<Game> findAll(Integer platformId) {
        platformService.findById(platformId);
        return gameRepository.findAllByPlatformPlatformId(platformId);
    }

    public Game create (Game obj){
        obj.setGameId(null);
        return gameRepository.save(obj);
    }

    public Game update(Integer id, Game objDto) {
        Game obj = findById(id);
        obj.setGameName(objDto.getGameName());
        obj.setGameDescription(objDto.getGameDescription());
        obj.setGameNote(objDto.getGameNote());

        return gameRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        gameRepository.deleteById(id);
    }

    public void remove(Integer platformId, Integer gameId) {
        Game game = findById(gameId);
        Optional<Platform> platform = platformRepository.findById(platformId);
        platform.ifPresent(value -> {
            game.getPlatform().remove(value);
            value.getGames().remove(game);
            gameRepository.save(game);
            platformRepository.save(value);
        });

    }
}