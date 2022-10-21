package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.dtos.GameDTO;

import java.util.List;

public interface GameService {
    Game findById(Integer id);

    List<Game> findAll(Integer platformId);

    Game create(Integer platformId, Game obj);

    Game update(Integer id, Game obj);

    void delete(Integer id);

}
