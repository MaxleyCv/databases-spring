package iot.lviv.films.repository;

import iot.lviv.films.domain.Actor;
import iot.lviv.films.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
