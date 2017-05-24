package no.westerdals.dolplads.itello.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dolplads on 14/05/2017.
 */
public interface CrudResource<T, E> {
    @RequestMapping(method = RequestMethod.POST)
    T create(T entity);

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    T getById(E id);

    @RequestMapping(method = RequestMethod.GET)
    List<T> findAll();

    @RequestMapping(method = RequestMethod.DELETE)
    void remove(T entity);

    @RequestMapping(method = RequestMethod.PUT)
    T update(T entity);
}
