package com.org.servlets;

import com.org.MyException;
import com.org.entities.Room;
import com.org.jdbc.Roomjdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elat on 11.04.2017.
 */
@WebServlet(urlPatterns = RoomDelete.PATH)
public class RoomDelete extends HttpServlet {

    public static final String PATH = "/roomDelete";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String ID = request.getParameter("id");
            if ((ID.matches("[a-zA-Z]*"))) {
                String message = "Id of room can not be " + ID + "!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException(message);
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Room room = Roomjdbc.getInstance().getById(id);
        try {
            Roomjdbc.getInstance().delete(room);
        }
        catch (NullPointerException ne) {
            ne.printStackTrace();
            String message = "You are trying to delete room which is not in the database!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        response.sendRedirect(RoomsGet.PATH);
    }
}
