package controller;

import entity.Team;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.nio.file.FileStore;

/**
 * A servlet to handle user favorite teams updates
 */
@WebServlet(
        urlPatterns = {"/updateFavorites"}
)
public class UpdateFavorites extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Forwards the user to a page where they can manage their favorite teams.
     * If no user is logged in, redirects to homepage.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();

        if (session.getAttribute("currentUser") == null) {
            logger.debug("not logged in. forwarding on to index.jsp");
            dispatcher = req.getRequestDispatcher("/index.jsp");
        } else {
            loadTeamsToSession(req);
            logger.debug("forwarding on to myTeams.jsp");
            dispatcher = req.getRequestDispatcher("/myTeams.jsp");
        }
        dispatcher.forward(req, resp);
    }

    /**
     * Handles updates to users favorite teams. Depending on the action
     * button submitted, a team will be added or removed for the user.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        String userName = currentUser.getUserName();

        String actionType = req.getParameter("actionType");
        logger.debug("Request to  " + actionType + " team to/from " + userName + "'s favorites");

        if (actionType.equals("add")) {
            String teamToAddName = req.getParameter("teamToAdd");
            logger.debug("doPost to add team: " + teamToAddName);
            User updatedUser = addTeamToFavorites(teamToAddName, userName);
            session.setAttribute("currentUser", updatedUser);
            logger.debug("*** UPDATED USER: " + updatedUser);
        }
        else if (actionType.equals("remove")) {
            String teamToRemoveName = req.getParameter("teamToRemove");
            logger.debug("doPost to remove team: " + teamToRemoveName);
            User updatedUser = removeTeamFromFavorites(teamToRemoveName, userName);
            session.setAttribute("currentUser", updatedUser);
            logger.debug("*** UPDATED USER: " + updatedUser);
        }
        else {
            logger.error("something went wrong, neither add nor remove team was requested...");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/myTeams.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Remove a team from a user's favorite teams
     *
     * @param teamName the name of the team to remove
     * @param userName the user's username
     * @return the updated user with the team removed from their favorites
     */
    private User removeTeamFromFavorites(String teamName, String userName) {
        logger.debug("removing team from favorites: " + teamName);

        TeamDao teamDao = new TeamDao();
        Team teamToRemove = teamDao.getByTeamName(teamName).get(0);
        logger.debug("team to remove: " + teamToRemove);

        UserDao userDao = new UserDao();
        User user = userDao.getByUserName(userName).get(0);
        logger.debug("user to remove from: " + user);

        user.removeTeamFromFavorites(teamToRemove);
        userDao.saveOrUpdate(user);

        User updatedUser = userDao.getByUserName(userName).get(0);
        logger.debug("Updated user [IN REMOVE]: " + updatedUser);
        return updatedUser;
    }

    /**
     * Add a team to a user's favorite teams
     *
     * @param teamName the name of the team to add
     * @param userName the user's username
     * @return the updated user with the team added to their favorites
     */
    private User addTeamToFavorites(String teamName, String userName) {
        logger.debug("adding team to " + userName + "'s favorites: " + teamName);

        TeamDao teamDao = new TeamDao();
        Team teamToAdd = teamDao.getByTeamName(teamName).get(0);
        logger.debug("team to add: " + teamToAdd);

        UserDao userDao = new UserDao();
        User user = userDao.getByUserName(userName).get(0);
        logger.debug("user to add to: " + user);

        user.addTeamToFavorites(teamToAdd);
        userDao.saveOrUpdate(user);

        User updatedUser = userDao.getByUserName(userName).get(0);
        logger.debug("Updated user [IN ADD]: " + updatedUser);
        return updatedUser;
    }


    /**
     * Load teams to session.
     *
     * @param req the http request //TODO refactor, used by multiple servlets
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