package com.example.brugerogemner.Controller;

import com.example.brugerogemner.Entiteter.Person;
import com.example.brugerogemner.Mapper.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeSet;

@WebServlet(name = "ServletOpret", value = "/ServletOpret")
public class ServletOpret extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String navn = request.getParameter("navn");
        String kode = request.getParameter("kode");

        Person person = new Person(navn,kode,  new TreeSet<>()  );

        try {
            person = Facade.makeNewPerson(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        Map<Integer,Person> personMap = (Map<Integer, Person>) getServletContext().getAttribute("personMap");

        if (personMap == null) {
            try {
                personMap = Facade.getAllPersons();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        personMap.put(person.getPersonId(), person);

        request.setAttribute("msg", person.getNavn() +  " du er nu klar til at logge ind med dit  brugernummer " + person.getPersonId() );
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
