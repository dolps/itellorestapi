package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dolplads on 14/05/2017.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
}
