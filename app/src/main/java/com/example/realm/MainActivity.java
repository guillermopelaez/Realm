package com.example.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private EditText editname, editEmail, editage, editGenero;
    private Button add, view, delete;
    private TextView textView3;
    private Realm realm;
    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }
    private void configView() {
        persona = new Persona();
        editname = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editaEmail);
        editage = (EditText) findViewById(R.id.editAge);
        editGenero = (EditText) findViewById(R.id.editGenero);
        add = (Button) findViewById(R.id.add);
        view = (Button) findViewById(R.id.view);
        delete = (Button) findViewById(R.id.delete);
        textView3 = (TextView) findViewById(R.id.textView3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               persona.setName(editname.getText().toString());
               persona.setEmail(editEmail.getText().toString());
               persona.setAge(editage.getText().toString());
               persona.setGenero(editGenero.getText().toString());
               CrupPersona.addPersona(persona);
                     }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh_database();
                CrupPersona.getAllPersona();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               CrupPersona.deleteTodo();
            }
        });

    }

    private void delete_database(String name) {
        final RealmResults<Persona> personas = realm.where(Persona.class).equalTo("Name",name).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                personas.deleteFromRealm(0);
            }
        });
    }

    private void refresh_database() {
        RealmResults<Persona> result = realm.where(Persona.class).findAllAsync();
        result.load();
        String output = "";

        for(Persona persona : result ){
            output += persona.toString();
        }

        textView3.setText(output);
    }

    private void save_to_database(final String Name, final String Age, final String Genero) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Persona persona = bgRealm.createObject(Persona.class);
                persona.setName(Name);
                persona.setAge(Age);
                persona.setGenero(Genero);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("Successs", "...............");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("Falied",error.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        realm.close();
    }
}
