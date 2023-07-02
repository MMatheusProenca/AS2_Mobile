package com.pucpr.alertaja.model;

public class Event {
    private long ID;
    private String name;
    private String data;
    private String local;
    private String descricao;

    public Event(long ID, String name, String data, String local, String descricao) {
        this.ID = ID;
        this.name = name;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
    }
    public Event(String name, String data, String local, String descricao) {
        this.name = name;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
    }
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
