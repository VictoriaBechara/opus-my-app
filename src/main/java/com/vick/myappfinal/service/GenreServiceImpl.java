package com.vick.myappfinal.service;

import com.vick.myappfinal.domain.Genre;
import com.vick.myappfinal.dtos.GenreDTO;
import com.vick.myappfinal.repositories.GenreRepository;
import com.vick.myappfinal.service.exceptions.DataIntegrityViolationException;
import com.vick.myappfinal.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GameServiceImpl gameServiceImpl;

    public Genre findById(Integer id){
        Optional<Genre> obj = genreRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found! Id: " + id + ", Tipo: " + Genre.class.getName()));
    }

    public List<Genre> findAll(){
        return  genreRepository.findAll();
    }

    public Genre create(Genre obj){
        obj.setGenreId(null);
        return genreRepository.save(obj);
    }

    public Genre update(Integer id, GenreDTO objDto){
        Genre obj = findById(id);
        obj.setGenreId(objDto.getGenreId());
        obj.setGenreName(objDto.getGenreName());

        return genreRepository.save(obj);
    }
    public void delete(Integer id){
        findById(id);
        try {
            genreRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("\n" +
                    "This genre cannot be deleted! It has associated games.");
        }
    }

    public Genre addGameToGenreById(Integer gameId, Integer genreId){
        Genre list = genreRepository.findById(genreId).orElseThrow(() -> new ObjectNotFoundException("Genre not found!"));

        list.getGames().add(gameServiceImpl.findById(gameId));
        genreRepository.save(list);

        return list;
    }
}

