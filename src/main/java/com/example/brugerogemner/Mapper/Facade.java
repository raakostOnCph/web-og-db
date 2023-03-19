package com.example.brugerogemner.Mapper;

import com.example.brugerogemner.Entiteter.Person;

import java.util.Map;

public class Facade
{
    public static Map<Integer, Person> getAllPersons()
    {
        return  DBMapper.getAllPersons();
    }
}
