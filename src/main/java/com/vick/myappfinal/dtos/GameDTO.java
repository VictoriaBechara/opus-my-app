package com.vick.myappfinal.dtos;

import com.vick.myappfinal.domain.Game;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class GameDTO {

    private Integer gameId;
    private String gameName;

    public  GameDTO(){
        super();
    }

    public GameDTO(@NotNull Game obj) {
        super();
        this.gameId = obj.getGameId();
        this.gameName = obj.getGameName();
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}