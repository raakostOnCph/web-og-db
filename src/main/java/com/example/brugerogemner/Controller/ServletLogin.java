package com.example.brugerogemner.Controller;

import com.example.brugerogemner.Entiteter.Person;
import com.example.brugerogemner.Mapper.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Map<Integer, Person> personMap;
        personMap = (Map<Integer, Person>) getServletContext().getAttribute("personMap");

        if (personMap == null) {
            try {
                personMap = Facade.getAllPersons();
                getServletContext().setAttribute("personMap",personMap);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (!personMap.containsKey(Integer.parseInt(navn))) {

            request.setAttribute("msg", "en bruger med den brugernummer findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        if (!personMap.get(Integer.parseInt(navn)).getKode().equalsIgnoreCase(kode)){

            request.setAttribute("msg", "forkert kode prøv igen");
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }

        HttpSession session = request.getSession();

        session.setAttribute("person", personMap.get(Integer.parseInt(navn)));

        request.getRequestDispatcher("WEB-INF/Brugreside.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
