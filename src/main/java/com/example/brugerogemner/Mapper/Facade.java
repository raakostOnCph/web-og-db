package com.example.brugerogemner.Mapper;

import com.example.brugerogemner.Entiteter.Person;

import java.sql.SQLException;
import java.util.Map;

public class Facade
{
    public static Map<Integer, Person> getAllPersons() throws SQLException
    {
        return  DBMapper.getAllPersons();
    }

    public static Person makeNewPerson(Person person) throws SQLException
    {
        return DBMapper.makeNewPerson(person);
    }
}
