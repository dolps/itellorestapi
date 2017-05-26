package no.westerdals.dolplads.itello.repository;

import no.westerdals.dolplads.itello.entity.Hotel;
import no.westerdals.dolplads.itello.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dolplads on 23/05/2017.
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long id);
}
