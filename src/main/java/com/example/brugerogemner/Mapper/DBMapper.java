package com.example.brugerogemner.Mapper;

import com.example.brugerogemner.Controller.AppStart;
import com.example.brugerogemner.Entiteter.Person;

import java.sql.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DBMapper
{
    public static Map<Integer, Person> getAllPersons() throws SQLException
    {

        Map<Integer, Person> personMap = new TreeMap<>();


        String sql = "SELECT * from personer";

        try (Connection con = AppStart.getConnectionPool().getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                Person person = new Person();
                person.setPersonId(resultSet.getInt("idpersoner"));
                person.setNavn(resultSet.getString("Navn"));
                person.setKode(resultSet.getString("kode"));
                //person.setStringSet(new TreeSet<>());
                person.setStringSet(hentEmner(person.getPersonId()));

                System.out.println(person.toString());
                personMap.put(person.getPersonId(), person);

            }
        }
        return personMap;
    }

    private static Set<String> hentEmner(int id) throws SQLException
    {

        Set<String> stringSet = new TreeSet<>();

        String sql = "select title from emner where fk_idPerson = ? ";

        try (Connection con = AppStart.getConnectionPool().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);)
        {

            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                stringSet.add(resultSet.getString("title"));
            }
        }

        return stringSet;
    }


    public static Person makeNewPerson(Person person) throws SQLException
    {

        String sql = "insert into personer (navn, kode) VALUES ( ? , ?) ";

        try (Connection con = AppStart.getConnectionPool().getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {

         ps.setString(1, person.getNavn());
         ps.setString(2, person.getKode());
        ps.execute();
        ResultSet resultSet = ps.getGeneratedKeys();

            System.out.println("der kom en nøgle"+ resultSet.next());
            System.out.println("rækkenummeret er " + resultSet.getInt(1));

         person.setPersonId(resultSet.getInt(1));

         return person;
        }




    }
}



