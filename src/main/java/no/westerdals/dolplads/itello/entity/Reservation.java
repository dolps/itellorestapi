package no.westerdals.dolplads.itello.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by dolplads on 23/05/2017.
 */
@Entity
@ToString
@Data
@NoArgsConstructor
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
    @JoinColumn
    private Hotel hotel;

    @ManyToOne
    @JoinColumn
    private Room room;

    private String useruid;

    private long dateIn;

    private long dateOut;

    private double totalCost;

    public Reservation(Hotel hotel, Room room, String useruid, long dateIn, long dateOut, double totalCost) {
        this.hotel = hotel;
        this.room = room;
        this.useruid = useruid;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.totalCost = totalCost;
    }
}
