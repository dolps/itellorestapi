package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.Reservation;
import no.westerdals.dolplads.itello.model.Booking;
import no.westerdals.dolplads.itello.repository.BookingRepository;
import no.westerdals.dolplads.itello.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private BookingRepository bookingRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void reserve(Reservation reservation) {
        log.log(Level.INFO, "reservation placed " + reservation.toString());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(path = "multi", method = RequestMethod.POST)
    public Booking multiRoomReservation(@RequestBody Booking booking) {
        log.log(Level.INFO, booking.toString());

        Booking result = new Booking();
        for (Reservation reservation : booking.getReservationList()) {
            Reservation v = reservationRepository.save(reservation);
            result.getReservationList().add(v);
        }
        return bookingRepository.save(booking);
    }

}
