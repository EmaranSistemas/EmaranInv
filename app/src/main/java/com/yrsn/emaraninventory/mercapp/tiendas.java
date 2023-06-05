package com.yrsn.emaraninventory.mercapp;

public class tiendas {
    String id,nombre;

    public tiendas(){

    }

    public tiendas(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getnombre(){
        return nombre;
    }

    public void setnombre(String nombre){
        this.nombre = nombre;
    }
}
