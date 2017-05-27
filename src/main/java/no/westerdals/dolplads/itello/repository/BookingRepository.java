package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dolplads on 26/05/2017.
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUseruidOrderByDateInAsc(String userId);
}
