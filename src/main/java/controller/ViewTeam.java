package controller;

import entity.Team;
import mockarooAPI.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.MockarooPlayerDao;
import persistence.TeamDao;
import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to display an individual team page
 */
@WebServlet(
        urlPatterns = {"/viewTeam"}
)

public class ViewTeam extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        loadTeamsToSession(req);
        String teamName = req.getParameter("teamName");
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;

        if (teamName != null && !teamName.isEmpty()) {
            TeamDao dao = new TeamDao();
            Team team = dao.getByTeamName(teamName).get(0);
            req.setAttribute("team", team);
            logger.debug("team added to the request." + team);

            MockarooPlayerDao playerDao = new MockarooPlayerDao();
            List<Player> players = playerDao.getPlayersByTeam(team.getId());
            req.setAttribute("players", players);
            logger.debug("players on team: " + players);
            dispatcher = req.getRequestDispatcher("/team.jsp");
        }
        else {
            logger.debug("teamName was empty...no team set");
            dispatcher = req.getRequestDispatcher("/error.jsp");
        }
        dispatcher.forward(req, resp);
    }

    /**
     * Load teams to session. //TODO refactor, used by several methods
     *
     * @param req the http request
     */
    protected void loadTeamsToSession(HttpServletRequest req) {

        HttpSession session = req.getSession();
        if (session.getAttribute("teams") == null) {
            TeamDao dao = new TeamDao();
            session.setAttribute("teams", dao.getAllTeams());
            logger.debug("teams attribute was empty. added to the session." + dao.getAllTeams());
        }
        else {
            logger.debug("teams already exists in the session. no need to add.");
        }
    }
}