package com.example.yriaven.mystic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DodawanieRekordu extends AppCompatActivity {

    EditText ID;
    EditText Funkcja;
    EditText Hasło;
    Button AddButton;
    Button ReturnButton;
    DBaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodawanie_rekordu);
        Toast message = Toast.makeText(DodawanieRekordu.this, "Uzupełnij pola", Toast.LENGTH_LONG);
        message.setGravity(Gravity.CENTER, 0, 0);
        message.show();
        ID = (EditText) findViewById(R.id.editText3);
        ID.setHint("Nowe ID");
        Funkcja = (EditText) findViewById(R.id.editText4);
        Funkcja.setHint("Nowa funkcja");
        Hasło = (EditText) findViewById(R.id.editText5);
        Hasło.setHint("Nowe hasło");
        AddButton = (Button) findViewById(R.id.button1);
        ReturnButton = (Button) findViewById(R.id.button2);
        DodajRekord();
        db = new DBaseManager(this);   //!

    }
    //return
    public void Return (View view)
    {
        DodawanieRekordu.this.finish();
        startActivity(new Intent(DodawanieRekordu.this, Opcje.class));
    }

    public void DodajRekord ()
    {
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ID.getText().toString().equals("") || Funkcja.getText().toString().equals("")
                        || Hasło.getText().toString().equals(""))
                {
                    Toast.makeText(DodawanieRekordu.this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    boolean ok = db.AddRecord(ID.getText().toString(), Funkcja.getText().toString()
                    , Hasło.getText().toString());

                    if (ok == true)
                    {
                        DodawanieRekordu.this.finish();
                        startActivity(new Intent(DodawanieRekordu.this, Baza.class));
                    }
                    else
                    {
                        Toast.makeText(DodawanieRekordu.this, "Błąd", Toast.LENGTH_SHORT).show();
                    }



                }

            }
        });
    }
}
