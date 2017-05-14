package no.westerdals.dolplads.itello.resource;

import no.westerdals.dolplads.itello.model.User;
import no.westerdals.dolplads.itello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dolplads on 14/05/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("users")
public class UserResource implements CrudResource<User, Long> {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public User getById(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(User user) {
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void patch(Long id, String firstName, String lastName) {
        if (!userRepository.exists(id)) {
            throw new ResourceNotFoundException("Resource does not exist");
        }

        User u = userRepository.findOne(id);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        userRepository.save(u);
    }

}
