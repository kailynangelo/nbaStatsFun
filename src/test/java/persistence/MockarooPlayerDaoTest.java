package persistence;

import mockarooAPI.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MockarooPlayerDaoTest {

    MockarooPlayerDao dao = null;
    @BeforeEach
    void setUp() {

        dao = new MockarooPlayerDao();
    }

    @Test
    void getAllPlayersSuccess() {

        List<Player> players = dao.getAllPlayers();
        assertNotNull(players);
    }

    @Test
    void getPlayersByTeamSuccess() {

        List<Player> players = dao.getPlayersByTeam(10);
        Player player1 = players.get(0);
        assertEquals("10", player1.getTeamId());
    }
}