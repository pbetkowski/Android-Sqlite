package com.example.yriaven.mystic;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Opcje extends AppCompatActivity {

    Button AddRecord;
    Button Update;
    Button Delete;
    Button Return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcje);
        AddRecord = (Button) findViewById(R.id.button1);
        Update = (Button) findViewById(R.id.button2);
        Delete = (Button) findViewById(R.id.button3);
        Return = (Button) findViewById(R.id.button4);
        Toast message = Toast.makeText(Opcje.this, "Wybierz opcję", Toast.LENGTH_SHORT);
        message.setGravity(Gravity.CENTER, 0, 0);
        message.show();
    }

    public void Return (View view)
    {
        Opcje.this.finish();
        startActivity(new Intent(Opcje.this, Baza.class));
    }

    public void Dodaj (View view)
    {
        Opcje.this.finish();
        startActivity(new Intent(Opcje.this, DodawanieRekordu.class));
    }

    public void Delete (View view)
    {
        Opcje.this.finish();
        startActivity(new Intent(Opcje.this, Usuwanie.class));
    }

    public void Update (View view)
    {
        Opcje.this.finish();
        startActivity(new Intent(Opcje.this, Update.class));
    }
}
