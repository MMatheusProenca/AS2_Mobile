package com.pucpr.alertaja.model;

import android.content.Context;

import java.util.ArrayList;
import android.view.Window;

public class DataModel {
    private static DataModel instance = new DataModel();
    private DataModel(){

    }
    public static DataModel getInstance(){
    return instance;
    }
    private ArrayList<Event> Events;
    private EventDataBase database;

    public void CreateDatabase(Context context){
        database = new EventDataBase(context);
        Events = database.getEventsFromDB();
    }
    public ArrayList<Event> getEvents(){
        return Events;
    }
    public Event getEvent(int pos){
        return Events.get(pos);
    }
    public Boolean addEvent(Event e) {
        long ID = database.CreateEventOnDB(e);
        if(ID > 0 ){
            e.setID(ID);
            Events.add(e);
            return true;
        }
        return false;
    }
    public Boolean insertEvent(Event e, int pos) {
        long ID = database.InsertventOnDB(e);
        if(ID > 0 ){
            Events.add(pos,e);
            return true;
        }
        return false;
    }
    public Boolean updateEvent(Event e, int pos){
    int count = database.UpdateEventOnDB(e);
    if(count == 1 ){
        Events.set(pos, e);
        return true;
    }
    return false;
    }

    public Boolean removeEvent(int pos){
        int count = database.UpdateEventOnDB(getEvent(pos));
        if(count == 1 ){
            Events.remove(pos);
            return true;
        }
        return false;
    }
}
