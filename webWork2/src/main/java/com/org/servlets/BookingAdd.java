package com.org.servlets;

/**
 * Created by Elat on 18.06.2017.
 */

import com.org.MyException;
import com.org.entities.Booking;
import com.org.jdbc.Bookingjdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = BookingAdd.PATH)
public class BookingAdd extends HttpServlet {
    public static final String PAGE = "/AddBooking.jsp";
    public static final String PATH = "/AddBooking";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("booking", new Booking());
        request.setAttribute("pageTitle", "Add Booking");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, RuntimeException {

        try {
            Booking booking = new Booking();
            booking.setDayOfBooking(Date.valueOf(request.getParameter("dayOfBooking").trim()));
            booking.setClientId(Integer.parseInt(request.getParameter("clientId").trim()));
            booking.setRoomId(Integer.parseInt(request.getParameter("roomId").trim()));
            booking.setDayIN(Date.valueOf(request.getParameter("DayIN").trim()));
            booking.setDayOUT(Date.valueOf(request.getParameter("DayOUT").trim()));
            Bookingjdbc.getInstance().create(booking);
            response.sendRedirect(GetBookings.PATH);

        } catch (MyException se)
        {
            se.printStackTrace();
            String message = "Error";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }


    }


}
