package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.domain.Genre;
import com.vick.myappfinal.domain.Platform;
import com.vick.myappfinal.repositories.GameRepository;
import com.vick.myappfinal.repositories.GenreRepository;
import com.vick.myappfinal.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private PlatformRepository platformRepository;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GenreRepository genreRepository;

    public void databaseInstance(){
        Platform p1 = new Platform(null, "console");
        Platform p2 = new Platform(null, "android");
        Platform p3 = new Platform(null, "pc");

        Genre gr1 = new Genre(null, "Simulation");
        Genre gr2 = new Genre(null, "Battle-Royal");
        Genre gr3 = new Genre(null, "Action");

        Game g1 = new Game(null, "The Witcher 3: Wild Hunt", "The Witcher 3: Wild Hunt is an action role-playing game with a third-person perspective. Players control Geralt of Rivia, a monster slayer known as a Witcher.", 10);
        Game g2 = new Game(null, "Minecraft", "The game which has been described as like an 'online Lego' involves building blocks and creating structures across different environments and terrains.", 10);
        Game g3 = new Game(null, "Fortnite", "Fortnite is a survival game where 100 players fight against each other in player versus player combat to be the last one standing.", 6);
        Game g4 = new Game(null, "Elden Ring", "Elden Ring is an action role-playing game played in a third person perspective, with gameplay focusing on combat and exploration.", 10);
        Game g5 = new Game(null, "The Sims 3", "The Sims 3 is a simulation where you can play with your sims life.", 7);

        g1.getPlatforms().addAll(Arrays.asList(p1,p3));
        this.gameRepository.saveAll(Arrays.asList(g1, g2, g3, g4, g5));

        gr1.getGames().addAll(Arrays.asList(g5, g2));
        gr2.getGames().addAll(Arrays.asList(g3));
        gr3.getGames().addAll(Arrays.asList(g1, g4));
        this.genreRepository.saveAll(Arrays.asList(gr1, gr2, gr3));

        p1.getGames().addAll(Arrays.asList(g1, g2, g3));
        p2.getGames().addAll(Arrays.asList(g2, g3));
        p3.getGames().addAll(Arrays.asList(g1, g2, g3, g4));

        this.platformRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
