package com.example.yriaven.mystic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yriaven on 25.06.17.
 */

public class DBaseManager extends SQLiteOpenHelper {

    //dane

    public static final String DATABASE_NAME = "Mystic.db";
    public static final String TABLE_NAME = "Dane";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Funkcja";
    public static final String Col_3 = "Haslo";



    //ograniczony konstruktor
    public DBaseManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER, Funkcja TEXT, Haslo TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    //dodawanie rekordu

    public boolean AddRecord (String ID, String Funkcja, String Haslo) // -1 = błąd
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, ID);
        values.put(COL_2, Funkcja);
        values.put(Col_3, Haslo);
        long wynik = db.insert(TABLE_NAME, null, values);

        if (wynik == -1)
        {
            return false;
        }

        else return true;
    }

    public Cursor getAll ()
    {
        String [] kolumny = {"ID", "Funkcja", "Haslo"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("Dane", kolumny, null, null, null, null, null);
        return kursor;
    }

    public Integer deleteData (String id)
    {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});

    }

    public boolean Update (String id, String funkcja, String haslo)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_1, id);
        values.put(COL_2, funkcja);
        values.put(Col_3, haslo);

        db.update(TABLE_NAME, values, "ID = ?", new String[] {id});
        return true;
    }
}
