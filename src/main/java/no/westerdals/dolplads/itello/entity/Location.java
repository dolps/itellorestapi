package no.westerdals.dolplads.itello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by dolplads on 15/05/2017.
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @NotNull
    private double longtitude;
    @NotNull
    private double latitude;
}
