package com.org.servlets;

import com.org.MyException;
import com.org.entities.Formation;
import com.org.jdbc.Formationjdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by Elat on 17.06.2017.
 */
@WebServlet(urlPatterns = FormationAdd.PATH)
public class FormationAdd extends HttpServlet {
    public static final String PAGE = "/AddFormation.jsp";
    public static final String PATH = "/AddFormation";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("formation", new Formation());
        request.setAttribute("pageTitle", "Add Formation");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, RuntimeException {

        try {
            Formation formation = new Formation();
            formation.setName(request.getParameter("name").trim());
            formation.setSurname(request.getParameter("surname").trim());
            formation.setNumber(Integer.parseInt(request.getParameter("number").trim()));
            formation.setTelephone(request.getParameter("telephone").trim());
            formation.setDayIN(Date.valueOf(request.getParameter("DayIN").trim()));
            formation.setDayOUT(Date.valueOf(request.getParameter("DayOUT").trim()));
            Formationjdbc.getInstance().create(formation);
            String message = "Thanks for formation.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            //throw new MyException("Exception while adding data!");
        } catch (MyException se) {
            se.printStackTrace();
            String message = "This telephone is in base. Please set another telephone.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }


    }
}
