package com.example.yriaven.mystic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    Button b1;
    Button b2;
    EditText e1;
    EditText e2;
    EditText e3;
    DBaseManager dbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        e1 = (EditText) findViewById(R.id.editText3);
        e1.setHint("Wybierz ID do aktualizacji");
        e2 = (EditText) findViewById(R.id.editText4);
        e3 = (EditText) findViewById(R.id.editText5);
        dbase = new DBaseManager(this);
        Update();




        Toast message = Toast.makeText(Update.this, "Wybierz numer ID, który chcesz uaktualnić a następnie uzupełnij pola", Toast.LENGTH_LONG);
        message.setGravity(Gravity.CENTER, 0, 0);
        message.show();
    }


    public void Powrot (View view)
    {
        Update.this.finish();
        startActivity(new Intent(Update.this, Opcje.class));
    }

    public void Update ()
    {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (e1.getText().toString().equals("") || e2.getText().toString().equals("")
                        || e3.getText().toString().equals(""))
                {
                    Toast.makeText(Update.this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                }

                else {
                    boolean isupdated = dbase.Update(e1.getText().toString(), e2.getText().toString()
                            , e3.getText().toString());

                    if (isupdated == true) {
                        Update.this.finish();
                        startActivity(new Intent(Update.this, Baza.class));
                    }
                     else
                    {
                        Toast.makeText(Update.this, "Błąd", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }




}
