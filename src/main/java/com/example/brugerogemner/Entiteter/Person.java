package com.example.brugerogemner.Entiteter;

import java.util.Set;

public class Person
{
    private int personId;
    private String navn;
    private String kode;
    private  Set<String> stringSet;


    public Person()
    {
    }

    // denne her er til når jeg opretter en ny bruger
    public Person(String navn, String kode, Set<String> stringSet)
    {
        this.navn = navn;
        this.kode = kode;
        this.stringSet = stringSet;
    }

    // det er når jeg henter en bruger fra database.
    public Person(int personId, String navn, String kode, Set<String> stringSet)
    {
        this.personId = personId;
        this.navn = navn;
        this.kode = kode;
        this.stringSet = stringSet;
    }

    public int getPersonId()
    {
        return personId;
    }

    public void setPersonId(int personId)
    {
        this.personId = personId;
    }

    public String getNavn()
    {
        return navn;
    }

    public void setNavn(String navn)
    {
        this.navn = navn;
    }

    public String getKode()
    {
        return kode;
    }

    public void setKode(String kode)
    {
        this.kode = kode;
    }

    public Set<String> getStringSet()
    {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet)
    {
        this.stringSet = stringSet;
    }

    @Override
    public String toString()
    {
        return "Person{" + "personId=" + personId + ", navn='" + navn + '\'' + ", kode='" + kode + '\'' + ", stringSet=" + stringSet + '}';
    }
}
