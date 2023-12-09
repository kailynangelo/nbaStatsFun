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

/**
 * A simple servlet to show users in db
 */

@WebServlet(
        urlPatterns = {"/updateFavorites"}
)

public class UpdateFavorites extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        loadTeamsToSession(req);
        logger.debug("forwarding on to myTeams.jsp");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/myTeams.jsp");
        dispatcher.forward(req, resp);
    }

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
            removeTeamFromFavorites(teamToRemoveName);
        }
        else {
            logger.error("something went wrong, neither add nor remove team was requested...");
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/myTeams.jsp");
        dispatcher.forward(req, resp);
    }

    private void removeTeamFromFavorites(String teamName) {
        logger.debug("removing team from favorites: " + teamName);

    }

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


    protected void loadTeamsToSession(HttpServletRequest req) {

        HttpSession session = req.getSession();
        if (session.getAttribute("teams") == null) {
            TeamDao dao = new TeamDao();
            //req.setAttribute("teams", dao.getAllTeams());
            session.setAttribute("teams", dao.getAllTeams());
            logger.debug("teams attribute was empty. added to the session." + dao.getAllTeams());
        }
        else {
            logger.debug("teams already exists in the session. no need to add.");
        }
    }
}