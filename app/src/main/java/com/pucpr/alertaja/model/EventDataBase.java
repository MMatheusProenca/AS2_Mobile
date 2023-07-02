package com.pucpr.alertaja.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Window;

import java.util.ArrayList;


public class EventDataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "events.sqlite";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE ="Event";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "name";
    private static final String COL_DATE = "date";
    private static final String COL_LOCAL = "local";
    private static final String COL_DESCRIPTION = "description";

    public EventDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String query = "Create table if not exists " + DB_TABLE + "( "+
                COL_ID + " integer primary key autoincrement, "+
                COL_NAME + " text, "+
                COL_DATE + " text, "+
                COL_LOCAL + " text, "+
                COL_DESCRIPTION + " text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long CreateEventOnDB(Event e){
        ContentValues values = new ContentValues();
        values.put(COL_NAME, e.getName());
        values.put(COL_DATE, e.getData());
        values.put(COL_LOCAL, e.getLocal());
        values.put(COL_DESCRIPTION, e.getDescricao());
        SQLiteDatabase database = getWritableDatabase();
        long ID = database.insert(DB_TABLE,null,values);
        database.close();
        return ID;
    }
    public long InsertventOnDB(Event e){
        ContentValues values = new ContentValues();
        values.put(COL_ID, e.getID());
        values.put(COL_NAME, e.getName());
        values.put(COL_DATE, e.getData());
        values.put(COL_LOCAL, e.getLocal());
        values.put(COL_DESCRIPTION, e.getDescricao());
        SQLiteDatabase database = getWritableDatabase();
        long ID = database.insert(DB_TABLE,null,values);
        database.close();
        return ID;
    }
    public ArrayList<Event> getEventsFromDB(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(DB_TABLE,null,null,null,null,null,null);
        ArrayList<Event> events = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                long ID = cursor.getLong(cursor.getColumnIndexOrThrow(COL_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(COL_DATE));
                String local = cursor.getString(cursor.getColumnIndexOrThrow(COL_LOCAL));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(COL_DESCRIPTION));
                events.add(new Event(ID, name, date, local, description));
            }while (cursor.moveToNext());
        }
        database.close();
        return events;
    }
    public int UpdateEventOnDB(Event e){
        ContentValues values = new ContentValues();
        values.put(COL_NAME, e.getName());
        values.put(COL_DATE, e.getData());
        values.put(COL_LOCAL, e.getLocal());
        values.put(COL_DESCRIPTION, e.getDescricao());
        String ID = String.valueOf(e.getID());
        SQLiteDatabase database = getWritableDatabase();
        int count = database.update(DB_TABLE,values,COL_ID + "=?", new String[]{ID});
        database.close();
        return count;
    }
    public int RemoveEventOnDB(Event e){
        String ID = String.valueOf(e.getID());
        SQLiteDatabase database = getWritableDatabase();
        int count = database.delete(DB_TABLE, COL_ID + "=?", new String[]{ID});
        database.close();
        return count;
    }
}
