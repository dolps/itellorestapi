package no.westerdals.dolplads.itello.resource;

import lombok.extern.java.Log;
import no.westerdals.dolplads.itello.entity.*;
import no.westerdals.dolplads.itello.model.AvailableRoomsRequest;
import no.westerdals.dolplads.itello.model.ReservationList;
import no.westerdals.dolplads.itello.repository.HotelRepository;
import no.westerdals.dolplads.itello.repository.ReservationRepository;
import no.westerdals.dolplads.itello.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dolplads on 15/05/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("hotels")
@Log
public class HotelResource implements CrudResource<Hotel, Long> {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Hotel create(Hotel entity) {
        return hotelRepository.save(entity);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @Override
    public Hotel getById(@PathVariable("id") Long id) {
        return hotelRepository.findOne(id);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @RequestMapping(path = "reservations", method = RequestMethod.POST)
    public Reservation placeReservation(@RequestBody Reservation reservation) {
        log.log(Level.INFO, "reservation:: " + reservation.toString());

        return reservationRepository.save(reservation);
    }

    @RequestMapping(path = "multiroomreservation", method = RequestMethod.POST)
    public ReservationList multiRoomReservation(@RequestBody ReservationList reservationList) {
        ReservationList result = new ReservationList();
        for (Reservation reservation : reservationList.getReservationList()) {
            Reservation v = reservationRepository.save(reservation);
            result.getReservationList().add(v);
        }

        return result;
    }


    @RequestMapping(path = "roomsAvailableOnRange")
    public List<Room> findRoomsAvailableInRange(@RequestBody AvailableRoomsRequest request) {
        log.log(Level.INFO, "in find rooms available in range");
        log.log(Level.INFO, request.toString());
        List<Room> availableRooms = roomRepository.findByHotelId(request.getHotelId());
        log.log(Level.INFO, "numberofrooms on hotel: " + availableRooms.size());
        List<Room> result = new ArrayList<>();


        for (Room room : availableRooms) {
            boolean roomavail = true;
            log.log(Level.INFO, "room: " + room.getId());
            List<Reservation> reservationsOnRoom = reservationRepository.findByRoom(room);

            for (Reservation reserve : reservationsOnRoom) {
                log.log(Level.INFO, "reservation: on room " + room.getId() + " " + convertMilly(reserve.getDateIn()) + " " + convertMilly(reserve.getDateOut()));
                log.log(Level.INFO, convertMilly(request.getStartInMillis()) + " " + convertMilly(request.getEndInMillis()));
                if (request.getStartInMillis() >= reserve.getDateIn() && request.getStartInMillis() <= reserve.getDateOut()
                        || request.getEndInMillis() >= reserve.getDateIn() && request.getEndInMillis() <= reserve.getDateOut()) {
                    roomavail = false;
                    log.log(Level.INFO, "ROOM is reserved that time");

                    if (request.getEndInMillis() >= reserve.getDateIn() && request.getEndInMillis() <= reserve.getDateOut()) {
                        log.log(Level.INFO, "jaja");
                    }
                }
            }
            if (roomavail) {
                result.add(room);
            }

        }
        return result;
    }

    private String convertMilly(long startInMillis) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(startInMillis);

        return c.getTime().toString();
    }

    @RequestMapping(path = "{id}/ava", method = RequestMethod.GET)
    public List<Room> getRoom(@PathVariable("id") Long id) {
        Room toBook = roomRepository.findOne(1L);
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 1);
        Calendar dayAfterTomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE, 2);
        Reservation s =
                new Reservation(toBook, null, tomorrow.getTimeInMillis(),
                        dayAfterTomorrow.getTimeInMillis(), 500.3);

        reservationRepository.save(s);


        List<Room> rooms = roomRepository.findByHotelId(id);


        return rooms;
    }


    @RequestMapping(path = "{id}/availabledates", method = RequestMethod.GET)
    public List<Calendar> getAvailableDatesByHotel(@PathVariable("id") Long id) {
        // List<Room> hotel = hotelRepository.findOne(id).getRooms();
        List<Room> rooms = roomRepository.findByHotelId(id);


        List<Hotel> hotels = hotelRepository.findAll();
        Hotel chosen = hotels.get(0);

        Logger a = Logger.getLogger(HotelResource.class.getName());
        a.log(Level.FINE, "IN GET AVAILABLEDATESBYHOTEL");
        List<Calendar> calendars = new ArrayList<>();
        Calendar today = GregorianCalendar.getInstance();
        Calendar tomorrow = GregorianCalendar.getInstance();
        Calendar dayAfterTomorrow = GregorianCalendar.getInstance();
        tomorrow.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE) + 1);
        dayAfterTomorrow.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE) + 1);
        calendars.add(today);
        calendars.add(tomorrow);
        calendars.add(dayAfterTomorrow);

        return calendars;
    }

    @Override
    public void remove(Hotel entity) {
        hotelRepository.delete(entity);
    }

    @Override
    public Hotel update(Hotel entity) {
        return hotelRepository.save(entity);
    }

    public Calendar[] gettdatesstub() {
        Calendar[] selectableDays = new Calendar[10];
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 10; i++) {
            Calendar call = Calendar.getInstance();
            call.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE) + i);
            selectableDays[i] = call;
        }
        return selectableDays;
    }
}
