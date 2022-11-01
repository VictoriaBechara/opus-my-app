package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.dtos.GameDTO;

import java.util.List;

public interface GameService {
    Game findById(Integer id);

    List<Game> findAllGames();

    List<Game> findAll(Integer platformId);

    Game create(Game obj);

    Game update(Integer id, Game objDto);

    void delete(Integer id);

    Game findByName(String gameName);

    void remove(Integer platformId, Integer gameId);
}
