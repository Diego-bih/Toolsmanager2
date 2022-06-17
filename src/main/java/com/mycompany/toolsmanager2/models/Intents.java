/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.toolsmanager2.models;

import java.sql.Timestamp;

/**
 *
 * @author Diego Ramirez
 */
public class Intents {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuari() {
        return idusuari;
    }

    public void setIdusuari(int idusuari) {
        this.idusuari = idusuari;
    }

    public int getId_nivell() {
        return id_nivell;
    }

    public void setId_nivell(int id_nivell) {
        this.id_nivell = id_nivell;
    }
     
    public Timestamp getInicioIntent() {
        return inicioIntent;
    }

    public void setInicioIntent(Timestamp inicioIntent) {
        this.inicioIntent = inicioIntent;
    }

    public Timestamp getFinIntent() {
        return finIntent;
    }

    public void setFinIntent(Timestamp finIntent) {
        this.finIntent = finIntent;
    }

    @Override
    public String toString() {
        return "Intents{" + "id=" + id + ", idusuari=" + idusuari + ", id_nivell=" + id_nivell + ", inicioIntent=" + inicioIntent + ", finIntent=" + finIntent + '}';
    }

    public Intents() {
    }

    public Intents(int id, int idusuari, int id_nivell, Timestamp inicioIntent, Timestamp finIntent) {
        this.id = id;
        this.idusuari = idusuari;
        this.id_nivell = id_nivell;
        this.inicioIntent = inicioIntent;
        this.finIntent = finIntent;
    }


    int id;
    int idusuari;
    int id_nivell;
    Timestamp inicioIntent;
    Timestamp finIntent;

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }
    long totalTime;
    
    
    
}
