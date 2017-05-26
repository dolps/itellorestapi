package no.westerdals.dolplads.itello.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dolplads on 15/05/2017.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double roomFee;
    private String imageUrl;

    private String locationName;
    private double longtitude;
    private double latitude;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
