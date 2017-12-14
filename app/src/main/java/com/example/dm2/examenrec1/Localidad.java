package com.example.dm2.examenrec1;

import android.graphics.drawable.Drawable;

/**
 * Created by dm2 on 14/12/2017.
 */
public class Localidad {

    private String idLocalidad,habitantes, superficie, web;
    private Drawable foto;

    public Localidad(String idLocalidad, Drawable foto, String habitantes, String superficie, String web) {
        this.idLocalidad = idLocalidad;
        this.foto = foto;
        this.habitantes = habitantes;
        this.superficie = superficie;
        this.web = web;
    }
    public Localidad(int i, String añana, int i1, float v, Drawable drawable, String s){}

    public String getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(String idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    public String getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(String habitantes) {
        this.habitantes = habitantes;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
