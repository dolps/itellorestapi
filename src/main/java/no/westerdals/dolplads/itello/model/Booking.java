package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dolplads on 15/05/2017.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;

    @OneToOne
    private Room room;

    private Date fromDate;
    private Date toDate;

    private double totalPrice;
}
