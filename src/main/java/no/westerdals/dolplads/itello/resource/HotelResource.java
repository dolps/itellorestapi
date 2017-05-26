package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.*;
import no.westerdals.dolplads.itello.model.AvailableRoomsRequest;
import no.westerdals.dolplads.itello.model.Booking;
import no.westerdals.dolplads.itello.repository.HotelRepository;
import no.westerdals.dolplads.itello.repository.ReservationRepository;
import no.westerdals.dolplads.itello.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dolplads on 15/05/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("hotels")
@Log
public class HotelResource implements CrudResource<Hotel, Long> {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(path = "roomsAvailableOnRange")
    public List<Room> findRoomsAvailableInRange(@RequestBody AvailableRoomsRequest request) {
        List<Room> availableRooms = roomRepository.findByHotelId(request.getHotelId());
        List<Room> result = new ArrayList<>();

        for (Room room : availableRooms) {
            boolean roomavail = true;
            List<Reservation> reservationsOnRoom = reservationRepository.findByRoom(room);

            for (Reservation reserve : reservationsOnRoom) {
                if (request.getStartInMillis() >= reserve.getDateIn() && request.getStartInMillis() <= reserve.getDateOut()
                        || request.getEndInMillis() >= reserve.getDateIn() && request.getEndInMillis() <= reserve.getDateOut()) {
                    roomavail = false;
                }
            }
            if (roomavail) {
                result.add(room);
            }

        }
        return result;
    }

    @Override
    public Hotel create(Hotel entity) {
        return hotelRepository.save(entity);
    }

    @Override
    public Hotel getById(@PathVariable("id") Long id) {
        return hotelRepository.findOne(id);
    }


    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void remove(Hotel entity) {
        hotelRepository.delete(entity);
    }

    @Override
    public Hotel update(Hotel entity) {
        return hotelRepository.save(entity);
    }
}
