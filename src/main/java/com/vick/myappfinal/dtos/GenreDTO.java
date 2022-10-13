package com.vick.myappfinal.dtos;

import com.vick.myappfinal.domain.Genre;

import java.util.Objects;

public class GenreDTO {
    private Integer genreId;
    private String genreName;

    public GenreDTO(Genre obj) {
        this.genreId = obj.getGenreId();
        this.genreName = obj.getGenreName();
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreDTO genreDTO = (GenreDTO) o;

        return Objects.equals(genreId, genreDTO.genreId);
    }

    @Override
    public int hashCode() {
        return genreId != null ? genreId.hashCode() : 0;
    }
}
