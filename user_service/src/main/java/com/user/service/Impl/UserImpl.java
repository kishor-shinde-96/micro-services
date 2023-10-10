package com.user.service.Impl;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    List<User> list = new ArrayList<>(Arrays.asList(
            new User(12L, "kishor", "8888888888"),
            new User(13L, "shree", "8888888889"),
            new User(14L, "tej", "8888888887")
    ));

    /**
     * Get a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return An optional containing the user if found, or an empty optional if not found.
     */
    @Override
    public User getUser(Long id) {
        return list.stream()
                .filter(user -> user.getUserId().equals(id))
                .findAny().orElse(null);
    }
}
