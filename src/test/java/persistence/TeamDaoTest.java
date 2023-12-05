package persistence;

import entity.Team;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Dao.
     */
   TeamDao dao;

    /**
     * Set up for unit tests.
     */
    @BeforeEach
    void setUp() {

        dao = new TeamDao();
        //Database database = Database.getInstance();
        //database.runSQL("cleandb.sql");
    }

    /**
     * Verifies success of get all users method.
     */
    @Test
    void getAllTeams() {
        List<Team> teams = dao.getAllTeams();
        assertEquals(30, teams.size());
    }

    /**
     * Verifies get user by user name method.
     */
    @Test
    void getTeamByTeamName() {
        String expectedTeam = "Milwaukee Bucks";
        List<Team> teams = dao.getByTeamName("Bucks");
        assertEquals(1, teams.size());
        assertEquals(expectedTeam, teams.get(0).getFullName());
    }


//    @Test
//    void insert() {
//    }
//
//    @Test
//    void saveOrUpdate() {
//    }
//
//    @Test
//    void delete() {
//    }
}