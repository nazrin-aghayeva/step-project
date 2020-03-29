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
      User user= new User("nazriniche","Aa112233!");
    createNewUser("nazriniche",
            "Aa112233!");
        assertEquals(Optional.of(user), get("nazriniche",
                "Aa112233!"));
    }
    @Test
    void add2() {
        assertFalse(createNewUser("nazrinichee", "aA112233!"));
    }


}