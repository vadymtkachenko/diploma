package com.org.servlets;

import com.org.MyException;
import com.org.entities.Client;
import com.org.jdbc.Clientjdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elat on 11.04.2017.
 */
@WebServlet(urlPatterns = ClientDelete.PATH)
public class ClientDelete extends HttpServlet {

    public static final String PATH = "/clientDelete";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String ID = request.getParameter("id");
            if ((ID.matches("[a-zA-Z]*"))) {
                String message = "Id of client can not be " + ID + "!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException(message);
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Client client = Clientjdbc.getInstance().getById(id);
        try {
            Clientjdbc.getInstance().delete(client);
        }
        catch (NullPointerException ne) {
            ne.printStackTrace();
            String message = "You are trying to delete a client who is not in the database!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        response.sendRedirect(ClientsGet.PATH);
    }
}
