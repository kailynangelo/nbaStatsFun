package persistence;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {

        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllUsers() {
        List<User> users = dao.getAllUsers();
        assertEquals(4, users.size());
    }

    @Test
    void getUserByUserName() {
        List<User> users = dao.getByUserName("kangelo");
        assertEquals(1, users.size());
        assertEquals("Angelo", users.get(0).getLastName());
    }


    @Test
    void insertSuccess() {
        User user = new User("Florence", "Jenkins", "flojenk", "student");
        int id = dao.insert(user);
        assertNotEquals(0, id);
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());
        List<User> userbyname = dao.getByUserName("flojenk");
        assertEquals("Florence", userbyname.get(0).getFirstName());
    }
}