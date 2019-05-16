package com.example.realm;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CrupPersona {
    private final static int calcularId() {


        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Persona.class).max("id");
        int nextId;
        if (currentIdNum == null) {
            nextId = 0;
        } else {
            nextId = currentIdNum.intValue() + 1;
        }
        return nextId;
    }

    public final static void addPersona(final Persona persona) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CrupPersona.calcularId();
                Persona realmPersona = realm.createObject(Persona.class, index);
                realmPersona.setName(persona.getName());
                realmPersona.setEmail(persona.getEmail());
                realmPersona.setAge(persona.getAge());
                realmPersona.setGenero(persona.getGenero());
            }
        });
    }

    public final static List<Persona> getAllPersona() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Persona> personas = realm.where(Persona.class).findAll();

        for (Persona persona : personas) {

            persona.toString();

        }

        return personas;
    }

    public final static Persona getPersonaByName(String name) {
        Realm realm = Realm.getDefaultInstance();
        Persona persona = realm.where(Persona.class).equalTo("name", name).findFirst();
    if (persona != null){
        persona.toString();
    }
        return persona;
    }

    public final static void deleteTodo (){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults <Persona> personas = realm.where(Persona.class).findAll();
    realm.deleteAll();
    realm.commitTransaction();


    }

}

