package com.org.servlets;

import com.org.jdbc.Formationjdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elat on 11.06.2017.
 */
@WebServlet(urlPatterns = GetFormations.PATH)
public class GetFormations extends HttpServlet{
    public static final String PAGE = "/formationsList.jsp";
    public static final String PATH = "/formationsList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("formations", Formationjdbc.getInstance().read());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(req,resp);
    }
}
