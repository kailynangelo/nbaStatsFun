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

    @Test
    void updateSuccess() {
        String newLastName = "Celinski";
        List<User> users = dao.getByUserName("stantheman");
        User userToUpdate = users.get(0);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        users = dao.getByUserName("stantheman");
        User updatedUser = users.get(0);
        assertEquals(newLastName, updatedUser.getLastName());
    }

    @Test
    void deleteSuccess() {

        List<User> users = dao.getAllUsers();
        int initialSize = users.size();
        dao.delete(users.get(0));
        users = dao.getAllUsers();
        assertEquals(initialSize - 1, users.size());
    }
}