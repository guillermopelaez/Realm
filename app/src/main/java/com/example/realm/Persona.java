package com.example.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Persona extends RealmObject {
    @PrimaryKey
    private int id;
    private String Name;
    private String Email;
    private String Age;
    private String Genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        this.Genero = genero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id + '\n' +
                " name= " + Name + '\n' +
                " email= " + Email + '\n' +
                " age= " + Age +
                ", genero= '" + Genero + '\n' +
                '}';
    }
}
