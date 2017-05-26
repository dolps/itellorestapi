package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.Hotel;
import no.westerdals.dolplads.itello.entity.Reservation;
import no.westerdals.dolplads.itello.model.DetailedReservationInfo;
import no.westerdals.dolplads.itello.repository.HotelRepository;
import no.westerdals.dolplads.itello.repository.ReservationRepository;
import no.westerdals.dolplads.itello.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by dolplads on 23/05/2017.
 */
@CrossOrigin("*")
@Log
@RestController
@RequestMapping("reservations")
public class ReservationResource {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void reserve(Reservation reservation) {
        log.log(Level.INFO, "reservation placed " + reservation.toString());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(path = "{uid}", method = RequestMethod.GET)
    public List<Reservation> findByUseruid(@PathVariable("uid") String userId) {
        return reservationRepository.findByUseruid(userId);
    }

    // Detailed info
    // Hotel
    // Date
    // before checkin display number of rooms
    // list of room ids if checkin onclick to display key will get room ids when checkin ready
    // checkin will be ready 8 am and just has confirmed checkin
    // totalprice

}
