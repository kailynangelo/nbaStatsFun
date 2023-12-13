package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import mockarooAPI.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves player data from a mockaroo api
 * TODO replace with real api!
 */
public class MockarooPlayerDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Retrieve all players from api
     *
     * @return a list of all players
     */
    public List<Player> getAllPlayers() {

        String mockPlayersURI = "https://my.api.mockaroo.com/players?key=d127d1e0"; //TODO add to/get from properties file?

        return getPlayers(mockPlayersURI);
    }

    /**
     * Retrieve players for a given team
     * @param teamId the id of the team of players requested
     * @return the list of players from the specified team
     */
    public List<Player> getPlayersByTeam(int teamId) {

        String mockPlayersURI = "https://my.api.mockaroo.com/players/" + teamId + "?key=d127d1e0"; //TODO see above

        return getPlayers(mockPlayersURI);
    }

    /**
     * Retrieves a list of players
     *
     * @param mockPlayersURI the uri to get the player data from
     * @return a list of players
     */
    private List<Player> getPlayers(String mockPlayersURI) {
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
