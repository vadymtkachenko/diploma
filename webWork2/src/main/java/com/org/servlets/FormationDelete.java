package com.org.servlets;

import com.org.MyException;
import com.org.entities.Formation;
import com.org.jdbc.Formationjdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elat on 18.06.2017.
 */
@WebServlet(urlPatterns = FormationDelete.PATH)
public class FormationDelete extends HttpServlet {

    public static final String PATH = "/formationDelete";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String ID = request.getParameter("id");
            if ((ID.matches("[a-zA-Z]*"))) {
                String message = "Id of formation can not be " + ID + "!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/message.jsp").forward(request, response);
                throw new MyException(message);
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Formation formation = Formationjdbc.getInstance().getById(id);
        try {
            Formationjdbc.getInstance().delete(formation);
        }
        catch (NullPointerException ne) {
            ne.printStackTrace();
            String message = "You are trying to delete formation which is not in the database!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        response.sendRedirect(GetFormations.PATH);
    }
}
