package com.example.brugerogemner.Controller;

import com.example.brugerogemner.Entiteter.Person;
import com.example.brugerogemner.Mapper.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Map<Integer, Person> personMap;

        personMap = (Map<Integer, Person>) getServletContext().getAttribute("personMap");

        if (personMap == null) {
           personMap = Facade.getAllPersons();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
