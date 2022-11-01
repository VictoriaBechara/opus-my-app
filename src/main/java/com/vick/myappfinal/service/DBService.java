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

    public void databaseInstance() {
        Platform p1 = new Platform(null, "Video-Game");
        Platform p3 = new Platform(null, "Computer");

        Genre gr1 = new Genre(null, "Simulation");
        Genre gr2 = new Genre(null, "Battle-Royal");
        Genre gr3 = new Genre(null, "Action");

        Game g1 = new Game(null, "The Witcher 3: Wild Hunt", "The Witcher 3: Wild Hunt is an action role-playing game with a third-person perspective. Players control Geralt of Rivia, a monster slayer known as a Witcher.", 10);
        Game g2 = new Game(null, "Minecraft", "The game which has been described as like an 'online Lego' involves building blocks and creating structures across different environments and terrains.", 10);
        Game g3 = new Game(null, "Fortnite", "Fortnite is a survival game where 100 players fight against each other in player versus player combat to be the last one standing.", 6);
        Game g4 = new Game(null, "Elden Ring", "Elden Ring is an action role-playing game played in a third person perspective, with gameplay focusing on combat and exploration.", 10);
        Game g5 = new Game(null, "The Sims 3", "The Sims 3 is a simulation where you can play with your sims life.", 7);
        Game g7 = new Game(null,"Counter-Strike", "The game pits two teams, Terrorists and Counter-Terrorists, against each other in different objective-based game modes.", 7 );
        Game g8 = new Game(null, "Age Of Mythology", "Is a Strategy Game in which you collect resources, build buildings, a good economy and spend your resources to train army of soldiers, heroes and myth units to fight.", 1000);
        Game g9 = new Game(null,"Donkey Kong", "It follows the adventures of a gorilla named Donkey Kong and his clan of other apes and monkeys. ", 10 );
        Game g10 = new Game(null,"Clash of Clans", "Is an online multiplayer game in which players form communities called clans, train troops, and attack other players to earn resources. ", 9 );


        this.gameRepository.saveAll(Arrays.asList(g1, g2, g3, g4, g5, g7, g8, g9, g10));
        this.genreRepository.saveAll(Arrays.asList(gr1, gr2, gr3));
        this.platformRepository.saveAll(Arrays.asList(p1, p3));

    }
}
