package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by dolplads on 15/05/2017.
 */
@Embeddable
@Data
@AllArgsConstructor
public class Location {
    @NotNull
    private long longtitude;
    @NotNull
    private long latitude;
}
