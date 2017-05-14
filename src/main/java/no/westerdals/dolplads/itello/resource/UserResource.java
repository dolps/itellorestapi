package no.westerdals.dolplads.itello.resource;

import no.westerdals.dolplads.itello.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dolplads on 14/05/2017.
 */
@RestController
@RequestMapping("users")
public class UserResource implements CrudResource<User, Long> {

    @RequestMapping(method = RequestMethod.GET)
    public List<User> get() {
        List<User> users = new ArrayList<>();
        users.add(new User("thomas", "dolplads"));
        return users;
    }

    @RequestMapping(path = ":id", method = RequestMethod.GET)
    public User getById(Long id) {
        return new User("by", "id");
    }

}
