package com.vick.myappfinal.dtos;

import com.vick.myappfinal.domain.Game;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class GameDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Integer gameId;
    private String gameName;

    public  GameDTO(){
        super();
    }

    public GameDTO(Game obj) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameDTO gameDTO = (GameDTO) o;

        return Objects.equals(gameId, gameDTO.gameId);
    }

    @Override
    public int hashCode() {
        return gameId != null ? gameId.hashCode() : 0;
    }
}