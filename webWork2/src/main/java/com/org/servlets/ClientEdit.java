package com.org.servlets;

import com.org.MyException;
import com.org.Validation;
import com.org.entities.Client;
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
@WebServlet(urlPatterns = ClientEdit.PATH)
public class ClientEdit extends HttpServlet {

    public static final String PAGE = "/clientEdit.jsp";
    public static final String PATH = "/clientEdit";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            if ((request.getParameter("id").matches("[a-zA-Z]*"))) {
                String message = "Id of client can not be " + request.getParameter("id") + "!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException(message);
            }
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendRedirect(ClientsGet.PATH);
            e.printStackTrace();
        }

        Client client = Clientjdbc.getInstance().getById(id);
        request.setAttribute("client", client);
        try {
            request.getAttribute("client").toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
            String message = "You are trying to edit the client who is not in the database!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        request.setAttribute("pageTitle", "Editing information about Guest");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Client client = Clientjdbc.getInstance().getById(id);
            Validation validation = new Validation();
            String name = request.getParameter("name").trim();
            String surname = request.getParameter("surname").trim();
            String with = request.getParameter("with").trim();
            String number = request.getParameter("telephone").trim();
            if (validation.validateClient(request, name, surname, with, number)) {
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException("Exception while updating data!");
            } else {
                client.setName(request.getParameter("name").trim());
                client.setSurname(request.getParameter("surname").trim());
                client.setWith(request.getParameter("with").trim());
                client.setTelephone(request.getParameter("telephone").trim());
                Clientjdbc.getInstance().update(client);
                response.sendRedirect(ClientsGet.PATH);
            }
        } catch (MyException se) {
            se.printStackTrace();
            String message = "This telephone is in base. Please set another telephone.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }
}
