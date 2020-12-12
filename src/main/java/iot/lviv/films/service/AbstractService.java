package iot.lviv.films.service;

import java.util.*;

public interface AbstractService<E, ID> {
    public List<E> getAll();
    public E getById(ID id);
    public E create(E newObject);
    public E update(ID id, E object);
    public void deleteById(ID id);
}
