package service;

import az.company.booking_project.entities.User;
import az.company.booking_project.services.UserService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest extends UserService {
@Test
    public void getUser1() {
        User user1 = new User("nazriniche",
                "Aa112233!");
        createNewUser("nazrinich",
                "Aa112233!");

        assertEquals(Optional.of(user1), getUser(user1));
    }

    @Test
    void createNewUser() {
        User user= new User(
                "nazriniche",
                "Aa112233!"
        );
        assertTrue(createNewUser("nazrinichkl", "Aa112233!"));
    }


}