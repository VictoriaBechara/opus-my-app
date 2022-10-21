package com.vick.myappfinal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor

@Entity
public class Game implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private String gameName;
    private String gameDescription;
    private Integer gameNote;

    @ManyToMany(mappedBy = "game")
    @JsonIgnore
    private List<Platform> platform = new ArrayList<>();

    @ManyToMany(mappedBy = "game")
    @JsonIgnore
    private List<Genre> genre = new ArrayList<>();

    public Game() {
        super();
    }

    public Game(Integer gameId, String gameName, String gameDescription, Integer gameNote) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.gameNote = gameNote;
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

    public List<Platform> getPlatform() {
        return platform;
    }

    public void setPlatform(List<Platform> platform) {
        this.platform = platform;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return Objects.equals(gameId, game.gameId);
    }

    @Override
    public int hashCode() {
        return gameId != null ? gameId.hashCode() : 0;
    }

}
