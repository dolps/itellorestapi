package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dolplads on 14/05/2017.
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
}
