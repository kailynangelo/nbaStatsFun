package controller;

import persistence.TeamDao;
import persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to show users in db
 */

@WebServlet(
        urlPatterns = {"/teams"}
)

public class AllTeams extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TeamDao dao = new TeamDao();
        req.setAttribute("teams", dao.getAllTeams());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/teams.jsp");
        dispatcher.forward(req, resp);
    }
}