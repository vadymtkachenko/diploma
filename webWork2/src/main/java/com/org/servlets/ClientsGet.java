package com.org.servlets;

import com.org.jdbc.Clientjdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elat on 11.04.2017.
 */
@WebServlet(urlPatterns = ClientsGet.PATH)
public class ClientsGet extends HttpServlet {


    public static final String PAGE = "/clientsList.jsp";
    public static final String PATH = "/clientsList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("clients", Clientjdbc.getInstance().read());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(req,resp);
    }
}

