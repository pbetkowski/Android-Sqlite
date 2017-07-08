package com.example.yriaven.mystic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Logowanie extends AppCompatActivity implements SensorEventListener {

    Button button1;
    Button button2;
    EditText passw;
    private SensorManager mSensorManager;
    private Sensor mProximity;
    private static final int SENSOR_SENSITIVITY = 4;
    public  final String haslo = "666";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        passw = (EditText) findViewById(R.id.editText);
        passw.setHint("Hasło");
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        startActivity(new Intent(Logowanie.this, Baza.class));  //do skasowania później


        Toast message = Toast.makeText(Logowanie.this, "Wprowadź hasło", Toast.LENGTH_LONG);
        message.setGravity(Gravity.CENTER, 0, 0);
        message.show();

    }


    public void Exit (View view)
    {
        AlertDialog.Builder close = new AlertDialog.Builder(Logowanie.this);
        close.setMessage("Zamknąć aplikację?");
        close.setCancelable(false);

        close.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Logowanie.this.finish();
            }
        });


        close.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        close.create();
        close.show();

    }

    //czujniki:


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        if (event.values[0] == 0 && passw.getText().toString().equals(haslo))
        {
            startActivity(new Intent(Logowanie.this, Baza.class));
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void FakeLog (View view)
    {
        Toast message = Toast.makeText(Logowanie.this, "Brak dostępu", Toast.LENGTH_LONG);
        message.setGravity(Gravity.CENTER, 0, 0);
        message.show();
    }

}
