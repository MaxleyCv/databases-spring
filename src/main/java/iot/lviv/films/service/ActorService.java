package iot.lviv.films.service;


import iot.lviv.films.domain.Actor;
import iot.lviv.films.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements AbstractService<Actor, Integer> {
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAll() {
        return this.actorRepository.findAll();
    }

    @Override
    public Actor getById(Integer integer) {
        return this.actorRepository.getOne(integer);
    }

    @Override
    public Actor create(Actor newObject) {
        return actorRepository.save(newObject);
    }

    @Override
    public Actor update(Integer integer, Actor object) {
        if (actorRepository.findById(integer).isPresent()){
            return this.actorRepository.save(object);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        if (actorRepository.findById(integer).isPresent()){
            this.actorRepository.deleteById(integer);
        }
    }
}
