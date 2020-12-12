package iot.lviv.films.controller;

import iot.lviv.films.domain.Actor;
import iot.lviv.films.dto.ActorDTO;
import iot.lviv.films.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping(value = "/actors")
@RestController
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ActorDTO>> getAll(){
        List<Actor> actors = actorService.getAll();
        if (actors != null) {
            List<ActorDTO> actorDTOS = new ArrayList<>();
            for (Actor actor : actors){
                actorDTOS.add(new ActorDTO(actor.getId(), actor.getName(), actor.getSurname()));
            }
            return new ResponseEntity<>(actorDTOS, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ActorDTO> getById(@PathVariable Integer id) {
        Actor actor = actorService.getById(id);
        if (actor != null) {
            ActorDTO actorDTO = new ActorDTO(
                    actor.getId(),
                    actor.getName(),
                    actor.getSurname()
            );
            return new ResponseEntity<>(actorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Actor newActor) {
        actorService.create(newActor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActorDTO> update(@PathVariable Integer id,
                                             @RequestBody Actor actor) {
        Actor actorOld = actorService.getById(id);
        if (actorOld != null) {
            actorService.update(id, actor);
            ActorDTO actorOldDTO = new ActorDTO(
                    actorOld.getId(),
                    actorOld.getName(),
                    actorOld.getSurname()
            );
            return new ResponseEntity<>(actorOldDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (actorService.getById(id) != null) {
            actorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
