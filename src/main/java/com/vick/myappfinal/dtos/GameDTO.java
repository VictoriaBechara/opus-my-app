package com.vick.myappfinal.dtos;

import com.vick.myappfinal.domain.Game;

import java.util.Objects;

public class GameDTO {

    private Integer gameId;
    private String gameName;
    private String gameDescription;
    private Integer gameNote;

    public GameDTO() {
        super();
    }

    public GameDTO(Game obj) {
        super();
        this.gameId = obj.getGameId();
        this.gameName = obj.getGameName();
        this.gameDescription = obj.getGameDescription();
        this.gameNote = obj.getGameNote();
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

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public Integer getGameNote() {
        return gameNote;
    }

    public void setGameNote(Integer gameNote) {
        this.gameNote = gameNote;
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
