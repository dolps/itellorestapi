package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.model.Booking;
import no.westerdals.dolplads.itello.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dolplads on 26/05/2017.
 */
@CrossOrigin("*")
@Log
@RestController
@RequestMapping("bookings")
public class BookingResource implements CrudResource<Booking, Long> {
    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(path = "user/{id}")
    public List<Booking> findByUser(@PathVariable("id") String id) {
        return bookingRepository.findByUseruid(id);
    }

    @Override
    public Booking create(Booking entity) {
        return null;
    }

    @Override
    public Booking getById(Long id) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public void remove(Booking entity) {

    }

    @Override
    public Booking update(Booking entity) {
        return null;
    }
}
