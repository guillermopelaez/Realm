package com.example.realm;

import io.realm.RealmObject;

public class Persona extends RealmObject {
    private String Name;
    private String Age;
    private String Genero;


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
                "name='" + Name + '\'' +
                ", age=" + Age +
                ", genero='" + Genero + '\'' +
                '}';
    }
}
