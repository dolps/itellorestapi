package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dolplads on 15/05/2017.
 */

@Entity
@AllArgsConstructor
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    //@OneToMany
    //private List<Room> rooms;

    // private double priceMin;

    // private double priceMax;
//    @Embedded
    //   private Location location;
}
