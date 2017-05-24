package no.westerdals.dolplads.itello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by dolplads on 24/05/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AvailableRoomsRequest {
    private long hotelId;
    private long startInMillis;
    private long endInMillis;
}
