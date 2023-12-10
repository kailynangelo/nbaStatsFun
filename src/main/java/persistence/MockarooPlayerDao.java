package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import mockarooAPI.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class MockarooPlayerDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<Player> getAllPlayers() {

        String mockPlayersURI = "https://my.api.mockaroo.com/players?key=d127d1e0";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(mockPlayersURI);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<Player> players = null;
        try {
            players = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Player.class));
            logger.debug(players);
        } catch (Exception e) {
            logger.error("error mapping players to object.", e);
        }
        return players;
    }

    public List<Player> getPlayersByTeam(int teamId) {

        String mockPlayersURI = "https://my.api.mockaroo.com/players/" + teamId + "?key=d127d1e0";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(mockPlayersURI);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<Player> players = null;
        try {
            players = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Player.class));
            logger.debug(players);
        } catch (Exception e) {
            logger.error("error mapping players to object.", e);
        }
        return players;
    }
}
