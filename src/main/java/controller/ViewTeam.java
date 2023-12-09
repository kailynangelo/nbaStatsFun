package controller;

import entity.Team;
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
        urlPatterns = {"/viewTeam"}
)

public class ViewTeam extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String teamName = req.getParameter("teamName");
        HttpSession session = req.getSession();

        if (teamName != null && !teamName.isEmpty()) {
            TeamDao dao = new TeamDao();
            req.setAttribute("team", dao.getByTeamName(teamName).get(0));
            logger.debug("team added to the request." + dao.getByTeamName(teamName));
        }
        else {
            logger.debug("teamName was empty...no team set");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/team.jsp");
        dispatcher.forward(req, resp);
    }
}