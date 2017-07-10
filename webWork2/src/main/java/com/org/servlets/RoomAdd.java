package com.org.servlets;

import com.org.MyException;
import com.org.Validation;
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
@WebServlet(urlPatterns = RoomAdd.PATH)
public class RoomAdd extends HttpServlet {
    public static final String PAGE = "/AddRoom.jsp";
    public static final String PATH = "/AddRoom";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("room", new Room());
        request.setAttribute("pageTitle", "Add Room");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, RuntimeException {

        try {
            Room room = new Room();
            Validation validation = new Validation();
            String type = request.getParameter("type").trim();
            String stage = request.getParameter("stage").trim();
            String price = request.getParameter("price").trim();
            String number = request.getParameter("number").trim();

                room.setType(request.getParameter("type").trim());
                room.setStage(Integer.parseInt(request.getParameter("stage").trim()));
                room.setNumber(Integer.parseInt(request.getParameter("number").trim()));
                room.setPrice(Double.parseDouble(request.getParameter("price").trim()));
                Roomjdbc.getInstance().create(room);
                response.sendRedirect(RoomsGet.PATH);

        } catch (MyException se) {
            se.printStackTrace();
            String message = "This number is in base. Please set another number of room.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }


    }


}