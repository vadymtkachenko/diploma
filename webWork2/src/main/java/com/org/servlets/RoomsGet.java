package com.org.servlets;

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
@WebServlet(urlPatterns = RoomsGet.PATH)
public class RoomsGet extends HttpServlet {


    public static final String PAGE = "/roomsList.jsp";
    public static final String PATH = "/roomsList";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("rooms", Roomjdbc.getInstance().read());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, RuntimeException {


        request.setAttribute("until", request.getParameter("until").trim());
        request.setAttribute("to", request.getParameter("to").trim());
        String IN = String.valueOf(request.getAttribute("until"));
        String OUT = String.valueOf(request.getAttribute("to"));


        String dateValid = "^\\d{4}-\\d{2}-\\d{2}$";

        if (!IN.matches(dateValid) || !OUT.matches(dateValid)) {
            String message = "Fill in two correct dates";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            throw new RuntimeException("Fill in two dates");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(GetFreeRooms.PATH);
        rd.forward(request, response);

    }
}
