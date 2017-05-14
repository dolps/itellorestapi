package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by dolplads on 14/05/2017.
 */
@AllArgsConstructor
@Data
@Entity
public class User {
    private String firstName;
    private String lastName;

}
