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
@WebServlet(urlPatterns = ClientAdd.PATH)
public class ClientAdd extends HttpServlet {
    public static final String PAGE = "/AddClient.jsp";
    public static final String PATH = "/AddClient";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("client", new Client());
        request.setAttribute("pageTitle", "Add Guest");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, RuntimeException {

        try {
            Client client = new Client();
            Validation validation = new Validation();
            String name = request.getParameter("name").trim();
            String surname = request.getParameter("surname").trim();
            String with = request.getParameter("with").trim();
            String telephoneNumber = request.getParameter("telephone").trim();
            if (validation.validateClient(request, name, surname, with, telephoneNumber)) {
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException("Exception while adding data!");
            } else {
                client.setName(request.getParameter("name").trim());
                client.setSurname(request.getParameter("surname").trim());
                client.setWith(request.getParameter("with").trim());
                client.setTelephone(request.getParameter("telephone").trim());
                Clientjdbc.getInstance().create(client);
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