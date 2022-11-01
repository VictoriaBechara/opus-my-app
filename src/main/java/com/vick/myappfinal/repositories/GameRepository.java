package com.vick.myappfinal.repositories;

import com.vick.myappfinal.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findAllByPlatformPlatformId(Integer platformId);
    Optional<Game> findByGameName(String gameName);

}
