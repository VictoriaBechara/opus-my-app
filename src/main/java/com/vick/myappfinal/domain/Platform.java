package com.vick.myappfinal.domain;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Platform implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformId;
    private String platformName;

    @ManyToMany
    @JoinTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Game> game = new ArrayList<>();

    public Platform() {
        super();
    }

    public Platform(Integer platformId, String platformName) {
        super();
        this.platformId = platformId;
        this.platformName = platformName;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public List<Game> getGames() {
        return game;
    }

    public void setGames(List<Game> game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform = (Platform) o;

        return Objects.equals(platformId, platform.platformId);
    }

    @Override
    public int hashCode() {
        return platformId != null ? platformId.hashCode() : 0;
    }
}