package no.westerdals.dolplads.itello.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by dolplads on 15/05/2017.
 * A bug found in the implementation dont allow lombok allargsconstructor together with jsonbackreference
 */

@Entity
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Hotel hotel;

    public Room(Hotel hotel) {
        this.hotel = hotel;
    }
}
