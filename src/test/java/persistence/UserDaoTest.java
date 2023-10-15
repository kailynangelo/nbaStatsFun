package persistence;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The User dao test.
 */
class UserDaoTest {

    /**
     * The Dao.
     */
    UserDao dao;

    /**
     * Set up for unit tests.
     */
    @BeforeEach
    void setUp() {

        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies success of get all users method.
     */
    @Test
    void getAllUsers() {
        List<User> users = dao.getAllUsers();
        assertEquals(4, users.size());
    }

    /**
     * Verifies get user by user name method.
     */
    @Test
    void getUserByUserName() {
        List<User> users = dao.getByUserName("kangelo");
        assertEquals(1, users.size());
        assertEquals("Angelo", users.get(0).getLastName());
    }


    /**
     * Verifies insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Florence", "Jenkins", "flojenk", "student");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        List<User> users = dao.getAllUsers();
        assertEquals(5, users.size());
        List<User> userByName = dao.getByUserName("flojenk");
        User insertedUser = userByName.get(0);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verifies update success.
     */
    @Test
    void updateSuccess() {
        String newLastName = "Celinski";
        List<User> users = dao.getByUserName("stantheman");
        User userToUpdate = users.get(0);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        users = dao.getByUserName("stantheman");
        User updatedUser = users.get(0);
        assertEquals(userToUpdate, updatedUser);
    }

    /**
     * Verifies delete success.
     */
    @Test
    void deleteSuccess() {

        List<User> users = dao.getAllUsers();
        int initialSize = users.size();
        dao.delete(users.get(0));
        users = dao.getAllUsers();
        assertEquals(initialSize - 1, users.size());
    }
}