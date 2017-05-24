package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.westerdals.dolplads.itello.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dolplads on 24/05/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationList {
    List<Reservation> reservationList = new ArrayList<>();
}
