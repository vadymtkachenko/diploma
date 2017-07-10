package com.org.servlets;

import com.org.MyException;
import com.org.jdbc.Roomjdbc;

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
@WebServlet(urlPatterns = GetFreeRooms.PATH)
public class GetFreeRooms extends HttpServlet {
    public static final String PAGE = "/GetFreeRooms.jsp";
    public static final String PATH = "/GetFreeRooms";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IN = String.valueOf(request.getAttribute("until"));
        String OUT = String.valueOf(request.getAttribute("to"));

        try {
            request.setAttribute("rooms", Roomjdbc.getInstance().getFreeRooms(IN, OUT));
            if (Roomjdbc.getInstance().getFreeRooms(IN, OUT).isEmpty()) {
                String sd = "There is not any employee yet.";
                request.setAttribute("noEmp", sd);
            }
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            String message = "You are trying to get a list of employees of the department, which is not in the database.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        } catch (MyException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }
}
