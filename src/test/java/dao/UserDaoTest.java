package dao;

import az.company.booking_project.dao.UserDao;
import az.company.booking_project.entities.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest extends UserDao {
    @Test
    void findAll() {
        User user= new User("nazrinichee", "aA112233!");
        create(user);
        assertEquals(user,getAll());
    }


    @Test
    void findById() throws IOException, ClassNotFoundException {
        User user= new User("nazrinichee", "aA112233!");
        create(user);
        assertEquals(Optional.of(user), getById(user.getId()));
    }


    @Test
    void add() {
        User user= new User("nazrinichee", "aA112233!");
        create(user);
        assertTrue(create(user));
    }

    @Test
    void remove() {
        User user= new User("nazrinichee", "aA112233!");
        create(user);
        assertTrue(delete(user.getId()));
    }
}