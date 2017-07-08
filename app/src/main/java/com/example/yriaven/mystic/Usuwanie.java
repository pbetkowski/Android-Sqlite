package com.example.yriaven.mystic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Usuwanie extends AppCompatActivity {

    Button deleteButton;
    Button ReturnButton;
    DBaseManager mydb;
    EditText deleteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuwanie);
        mydb = new DBaseManager(this);
        deleteButton = (Button) findViewById(R.id.button1);
        ReturnButton = (Button) findViewById(R.id.button2);
        deleteId = (EditText) findViewById(R.id.editText1);
        deleteData();
        Toast.makeText(Usuwanie.this, "Wybierz rekord do skasowania", Toast.LENGTH_SHORT).show();
    }


    public void powrót (View view)
    {
        Usuwanie.this.finish();
        startActivity(new Intent(Usuwanie.this, Opcje.class));
    }

    public void deleteData ()
    {
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer deleteRow = mydb.deleteData(deleteId.getText().toString());

                if (deleteRow > 0)
                {
                    Toast.makeText(Usuwanie.this, "Usunięto pomyślnie", Toast.LENGTH_SHORT).show();
                    deleteId.setText("");
                }

                else
                {
                    Toast.makeText(Usuwanie.this, "Błąd", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
