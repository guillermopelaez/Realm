package com.example.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Persona extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String email;
    private String age;
    private String genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id + '\n' +
                " name= " + name + '\n' +
                " email= " + email + '\n' +
                " age= " + age + '\n' +
                ", genero= '" + genero + '\n' +
                '}';
    }
}
