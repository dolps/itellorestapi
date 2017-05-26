package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.westerdals.dolplads.itello.entity.Hotel;
import no.westerdals.dolplads.itello.entity.Reservation;
import no.westerdals.dolplads.itello.entity.User;

import javax.jws.Oneway;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dolplads on 24/05/2017.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn
    private Hotel hotel;

    private String useruid;

    @OneToMany(fetch = FetchType.EAGER)
    List<Reservation> reservationList = new ArrayList<>();
}
