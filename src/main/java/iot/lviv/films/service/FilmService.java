package iot.lviv.films.service;


import iot.lviv.films.domain.Film;
import iot.lviv.films.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements AbstractService<Film, Integer> {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film getById(Integer integer) {
        return filmRepository.getOne(integer);
    }

    @Override
    public Film create(Film newObject) {
        return filmRepository.save(newObject);
    }

    @Override
    public Film update(Integer integer, Film object) {
        if (filmRepository.findById(integer).isPresent()){
            return filmRepository.save(object);
        }
        else return null;
    }

    @Override
    public void deleteById(Integer integer) {
        if (filmRepository.findById(integer).isPresent()){
            filmRepository.deleteById(integer);
        }
    }
}
