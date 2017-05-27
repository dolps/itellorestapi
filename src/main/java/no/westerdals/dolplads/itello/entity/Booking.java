package no.westerdals.dolplads.itello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.Hotel;
import no.westerdals.dolplads.itello.entity.Reservation;
import no.westerdals.dolplads.itello.entity.User;
import no.westerdals.dolplads.itello.model.BookingStatus;

import javax.jws.Oneway;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by dolplads on 24/05/2017.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn
    private Hotel hotel;

    private String useruid;

    private long dateIn;
    private long dateOut;

    private String bookingStatus;

    @OneToMany(fetch = FetchType.EAGER)
    List<Reservation> reservationList = new ArrayList<>();

    public boolean isCheckinPossible() {
        log.log(Level.INFO, "IS CHECKIN POSSIBLE: " + bookingStatus);
        if (bookingStatus.equals(BookingStatus.BOOKED)) {
            Calendar today = Calendar.getInstance();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dateIn);

            return calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)
                    && calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                    && calendar.get(Calendar.DATE) == today.get(Calendar.DATE);
        }

        log.log(Level.INFO, "FALSE: ");
        return false;
    }
}
