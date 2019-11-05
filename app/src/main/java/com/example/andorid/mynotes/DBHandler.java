package com.example.andorid.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "My Notes";
    private static final String TABLE_NOTES = "Notes";
    private static final String KEY_NAME = "Notes";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTES + "(" + KEY_NAME + " TEXT" + ")";
                db.execSQL(CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
    }

    public void addRecord(Notes notes){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, notes.getNote());

        db.insert(TABLE_NOTES, null, values);
        db.close();
    }
}
