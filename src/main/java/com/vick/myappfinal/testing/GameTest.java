package com.vick.myappfinal.testing;

import com.vick.myappfinal.domain.Game;
import com.vick.myappfinal.repositories.GameRepository;
import com.vick.myappfinal.service.GameServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private GameRepository gameRepository;

    private final Game g1 = Game.builder().gameId(1).gameName("test").gameDescription("test description").gameNote(0).build();

    @DisplayName("JUnit test for findById method")
    @Test
    public void should_find_by_id(){
        //GIVEN
        given(gameRepository.findById(1)).willReturn(Optional.ofNullable(g1));

        //WHEN
        Game gameFound = gameService.findById(g1.getGameId());
        System.out.println("Game " + g1.getGameName() + " as found!");

        //THEN
        assertThat(gameFound).isNotNull();

    }


}
