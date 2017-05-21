package no.westerdals.dolplads.itello.resource;

import no.westerdals.dolplads.itello.model.Hotel;
import no.westerdals.dolplads.itello.model.User;
import no.westerdals.dolplads.itello.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dolplads on 15/05/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("hotels")
public class HotelResource implements CrudResource<Hotel, Long> {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel entity) {
        return hotelRepository.save(entity);
    }

    @Override
    public Hotel getById(Long id) {
        return hotelRepository.findOne(id);
    }

    @Override
    public List<Hotel> findAll() {

        List<Hotel> hotels = hotelRepository.findAll();
        if (hotels == null || hotels.size() == 0) {
            List<Hotel> incase = new ArrayList<>();
            incase.add(new Hotel(1L, "cool hotel", "nice description", "https://www.w3schools.com/css/img_mountains.jpg"));
            return incase;
        } else {
            return hotels;
        }

    }

    @Override
    public void remove(Hotel entity) {
        hotelRepository.delete(entity);
    }

    @Override
    public Hotel update(Hotel entity) {
        return hotelRepository.save(entity);
    }
}
