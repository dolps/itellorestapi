package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.entity.User;
import no.westerdals.dolplads.itello.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dolplads on 26/05/2017.
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
