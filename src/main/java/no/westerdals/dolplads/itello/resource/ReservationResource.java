package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.Hotel;
import no.westerdals.dolplads.itello.entity.Reservation;
import no.westerdals.dolplads.itello.entity.Room;
import no.westerdals.dolplads.itello.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

    @RequestMapping(method = RequestMethod.POST)
    public void reserve(Reservation reservation) {
        log.log(Level.INFO, "reservation placed " + reservation.toString());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
