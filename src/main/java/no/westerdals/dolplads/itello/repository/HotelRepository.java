package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dolplads on 15/05/2017.
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
