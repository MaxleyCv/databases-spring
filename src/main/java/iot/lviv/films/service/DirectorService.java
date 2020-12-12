package iot.lviv.films.service;

import iot.lviv.films.domain.Director;
import iot.lviv.films.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService implements AbstractService<Director, Integer>{
    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    @Override
    public Director getById(Integer integer) {
        return directorRepository.getOne(integer);
    }

    @Override
    public Director create(Director newObject) {
        return directorRepository.save(newObject);
    }

    @Override
    public Director update(Integer integer, Director object) {
        if (directorRepository.findById(integer).isPresent()){
            return directorRepository.save(object);
        } else return null;
    }

    @Override
    public void deleteById(Integer integer) {
        if (directorRepository.findById(integer).isPresent()){
            directorRepository.deleteById(integer);
        }
    }
}
