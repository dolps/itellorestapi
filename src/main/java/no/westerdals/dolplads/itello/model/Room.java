package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by dolplads on 15/05/2017.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private RoomType roomType;

    private double dayPrice;

    @OneToOne
    private Booking currentBooking;

    public boolean isBooked() {
        return currentBooking != null;
    }
}
