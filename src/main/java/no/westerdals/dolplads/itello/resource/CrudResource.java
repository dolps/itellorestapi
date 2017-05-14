package no.westerdals.dolplads.itello.resource;

import no.westerdals.dolplads.itello.model.User;

import java.util.List;

/**
 * Created by dolplads on 14/05/2017.
 */
public interface CrudResource<E, T> {
    List<T> get();

    T getById(E id);
}
