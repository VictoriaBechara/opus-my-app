package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.dtos.GameDTO;
import com.vick.myappfinal.repositories.GameRepository;
import com.vick.myappfinal.service.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository gameRepository;

    public Game findById(Integer id){
        Optional<Game> obj = gameRepository.findById(id);
        return obj.orElse(null);
                //orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Game.class.getName()));
    }

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game create (Game obj){
        obj.setGameId(null);
        return gameRepository.save(obj);
    }

    public Game update(Integer id, GameDTO objDto) {
        Game obj = findById(id);
        obj.setGameName(objDto.getGameName());
        obj.setGameDescription(objDto.getGameDescription());
        obj.setGameNote(objDto.getGameNote());

        return gameRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            gameRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("\n" +
                    "This game cannot be deleted! It has associated platforms.");
        }
    }

}