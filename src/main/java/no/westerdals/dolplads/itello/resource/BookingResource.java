package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.Booking;
import no.westerdals.dolplads.itello.model.BookingStatus;
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
        //findTop10ByOrderByLevelDesc();
        List<Booking> bookingsbyUser = bookingRepository.findByUseruidOrderByDateInAsc(id);

        updateIfCheckinInToday(bookingsbyUser);

        return bookingsbyUser;
    }

    private void updateIfCheckinInToday(List<Booking> bookingsbyUser) {
        bookingsbyUser.forEach(booking -> {
            if (booking.isCheckinPossible()) {
                booking.setBookingStatus(BookingStatus.CHECKIN);
                bookingRepository.save(booking);
            }
        });
    }

    @RequestMapping(path = "{id}/updatebookingstatus")
    public Booking updateBookingStatus(@PathVariable("id") Long bookingId) {
        Booking booking = bookingRepository.findOne(bookingId);
        switch (booking.getBookingStatus()) {
            case BookingStatus.CHECKIN:
                booking.setBookingStatus(BookingStatus.CHECKEDIN);
                break;
            case BookingStatus.CHECKEDIN:
                booking.setBookingStatus(BookingStatus.CHECKEDOUT);
        }
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> bookings = bookingRepository.findAll();

        updateIfCheckinInToday(bookings);

        return bookings;
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
    public void remove(Booking entity) {

    }

    @Override
    public Booking update(Booking entity) {
        return null;
    }
}
