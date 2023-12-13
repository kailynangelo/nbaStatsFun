package controller;

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
 * A servlet to show teams from the database
 */

@WebServlet(
        urlPatterns = {"/teams"}
)
public class AllTeams extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO refactor loading of teams to session... used in Update favorites, View team as well
        HttpSession session = req.getSession();
        if (session.getAttribute("teams") == null) {
            TeamDao dao = new TeamDao();
            session.setAttribute("teams", dao.getAllTeams());
            logger.debug("teams attribute was empty. added to the session." + session.getAttribute("teams"));
        }
        else {
            logger.debug("teams already exists in the session. no need to add.");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/teams.jsp");
        dispatcher.forward(req, resp);
    }
}