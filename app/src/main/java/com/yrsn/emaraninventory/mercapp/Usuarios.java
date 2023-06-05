package com.yrsn.emaraninventory.mercapp;


public class Usuarios {
    String id,tienda,producto,inventario;

    public Usuarios() {
    }

    public Usuarios(String id, String tienda, String producto, String inventario) {
        this.id = id;
        this.tienda = tienda;
        this.producto = producto;
        this.inventario = inventario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettienda() {
        return tienda;
    }

    public void settienda(String tienda) {
        this.tienda = tienda;
    }

    public String getproducto() {
        return producto;
    }

    public void setproducto(String producto) {
        this.producto = producto;
    }

    public String getinventario() {
        return inventario;
    }

    public void setinventario(String inventario) {
        this.inventario = inventario;
    }
}