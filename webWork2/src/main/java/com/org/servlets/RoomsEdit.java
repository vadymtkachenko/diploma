package com.org.servlets;

import com.org.MyException;
import com.org.entities.Room;
import com.org.jdbc.Roomjdbc;

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
@WebServlet(urlPatterns = RoomsEdit.PATH)
public class RoomsEdit extends HttpServlet {

    public static final String PAGE = "/roomsEdit.jsp";
    public static final String PATH = "/roomsEdit";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            if ((request.getParameter("id").matches("[a-zA-Z]*"))) {
                String message = "Id of room can not be " + request.getParameter("id") + "!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException(message);
            }
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendRedirect(RoomsGet.PATH);
            e.printStackTrace();
        }

        Room room = Roomjdbc.getInstance().getById(id);
        request.setAttribute("room", room);
        try {
            request.getAttribute("room").toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
            String message = "You are trying to edit room which is not in the database!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        request.setAttribute("pageTitle", "Editing information about Room");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Room room = Roomjdbc.getInstance().getById(id);



                room.setType(request.getParameter("type").trim());
                room.setStage(Integer.parseInt(request.getParameter("stage").trim()));
                room.setNumber(Integer.parseInt(request.getParameter("number").trim()));
                room.setPrice(Double.parseDouble(request.getParameter("price").trim()));
                Roomjdbc.getInstance().update(room);
                response.sendRedirect(RoomsGet.PATH);

        } catch (MyException se) {
            se.printStackTrace();
            String message = "This telephone is in base. Please set another number.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }
}
