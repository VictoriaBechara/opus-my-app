package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.dtos.GameDTO;
import com.vick.myappfinal.repositories.GameRepository;
import com.vick.myappfinal.service.exceptions.DataIntegrityViolationException;
import com.vick.myappfinal.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private  PlatformServiceImpl platformService;

    @Autowired
    private GenreServiceImpl genreService;

    public Game findById(Integer id) {
        Optional<Game> obj = gameRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Game.class.getName()));
    }

    public List<Game> findAll(Integer platformId) {
        platformService.findById(platformId);
        return gameRepository.findAllByPlatformPlatformId(platformId);
    }

    public Game create(Game obj) {
        obj.setGameId(null);
        return gameRepository.save(obj);
    }

    public Game update(Integer id, Game obj) {
        Game newObj = findById(id);
        updateData(newObj, obj);
        return gameRepository.save(newObj);
    }

    private void updateData(Game newObj, Game obj) {
        newObj.setGameNote(obj.getGameNote());
        newObj.setGameDescription(obj.getGameDescription());
        newObj.setGameNote(obj.getGameNote());
    }

    public void delete(Integer id) {
        findById(id);
        try {
            gameRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("\n" +
                    "This game cannot be deleted! It has associated platforms.");
        }
    }

}