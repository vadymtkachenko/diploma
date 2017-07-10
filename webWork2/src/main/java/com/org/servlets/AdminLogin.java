package com.org.servlets;

import com.org.jdbc.Loginjdbc;

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
@WebServlet(urlPatterns = AdminLogin.PATH)
public class AdminLogin extends HttpServlet {


    public static final String PAGE = "/LoginPage.jsp";
    public static final String PATH = "/LoginPage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = Loginjdbc.getInstance().readLogin();
        String password = Loginjdbc.getInstance().readPassword();

        String name = req.getParameter("login");
        String password1 = req.getParameter("password");


        if (name.equals(login) && password.equals(password1)) {
            resp.sendRedirect(RoomsGet.PATH);
        } else {
            RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher(PAGE);
            dispatcher2.forward(req, resp);
        }
    }
}