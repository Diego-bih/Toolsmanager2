/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.toolsmanager2.models;

/**
 *
 * @author Diego Ramirez
 */
public class Usuari {

    public Usuari(int id, String nom, String llinatge, String username, String email, String password, String foto, String fotoMimeType) {
        this.id = id;
        this.nom = nom;
        this.llinatge = llinatge;
        this.username = username;
        this.email = email;
        this.password = password;
        this.foto = foto;
        this.fotoMimeType = fotoMimeType;
    }
    
        public Usuari(String nom, String llinatge, String username, String email, String password, String foto, String fotoMimeType) {
        this.nom = nom;
        this.llinatge = llinatge;
        this.username = username;
        this.email = email;
        this.password = password;
        this.foto = foto;
        this.fotoMimeType = fotoMimeType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatge() {
        return llinatge;
    }

    public void setLlinatge(String llinatge) {
        this.llinatge = llinatge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFotoMimeType() {
        return fotoMimeType;
    }

    public void setFotoMimeType(String fotoMimeType) {
        this.fotoMimeType = fotoMimeType;
    }

    @Override
    public String toString() {
        return "Usuari{" + "id=" + id + ", nom=" + nom + ", llinatge=" + llinatge + ", username=" + username + ", email=" + email + ", password=" + password + ", foto=" + foto + ", fotoMimeType=" + fotoMimeType + '}';
    }

    int id;
    String nom;
    String llinatge;
    String username;
    String email;
    String password;
    String foto;
    String fotoMimeType;
    
}
