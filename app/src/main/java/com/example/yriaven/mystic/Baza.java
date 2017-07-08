package com.example.yriaven.mystic;

import android.content.Intent;
import android.database.Cursor;
import android.media.tv.TvContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Baza extends AppCompatActivity {

    Button opcje;
    Button logout;
    DBaseManager mydb;
    TextView IdWyswietl;
    TextView FunkcjaWyswietl;
    TextView HasloWyswietl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baza);
        mydb = new DBaseManager(this);
        IdWyswietl = (TextView) findViewById(R.id.textView2);
        FunkcjaWyswietl = (TextView) findViewById(R.id.textView3);
        HasloWyswietl = (TextView) findViewById(R.id.textView4);

        opcje = (Button) findViewById(R.id.options);
        logout = (Button) findViewById(R.id.logout);

        Cursor k = mydb.getAll();

        while (k.moveToNext())
        {
            String ID = k.getString(0);
            String Funkcja = k.getString(1);
            String Haslo = k.getString(2);

            IdWyswietl.setText(IdWyswietl.getText() + "\n" + ID);
            FunkcjaWyswietl.setText(FunkcjaWyswietl.getText() + "\n" + Funkcja);
            HasloWyswietl.setText(HasloWyswietl.getText() + "\n" + Haslo);
        }



    }


    //wylogowanie
    public void wyloguj(View view)  //do sprawdzenia
    {
        Baza.this.finish();
        startActivity(new Intent(Baza.this, Logowanie.class));
    }

    //opcje

    public void options(View view)
    {
        startActivity(new Intent(Baza.this, Opcje.class));
    }
}
