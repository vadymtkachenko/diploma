package com.org.servlets;

import com.org.jdbc.Bookingjdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elat on 18.06.2017.
 */
@WebServlet(urlPatterns = GetBookings.PATH)
public class GetBookings extends HttpServlet {
    public static final String PAGE = "/bookingsList.jsp";
    public static final String PATH = "/bookingsList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("bookings", Bookingjdbc.getInstance().read());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(req,resp);
    }
}
