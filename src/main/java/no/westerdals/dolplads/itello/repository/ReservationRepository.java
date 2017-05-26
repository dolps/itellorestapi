package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.entity.Reservation;
import no.westerdals.dolplads.itello.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dolplads on 23/05/2017.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoom(Room room);

    List<Reservation> findByUseruid(String userId);
}
