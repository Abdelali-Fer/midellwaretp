/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carnetadresses;

/**
 *
 * @author PcTec
 */
public class Adresse {
    private int id;
    private String nomPersonne;
    private String rue;
    private String ville;
    
    

    public Adresse(String nomPersonne, String rue, String ville) {
        this.nomPersonne = nomPersonne;
        this.rue = rue;
        this.ville = ville;
    }

    public String getNomPersonne() { return nomPersonne; }
    public String getRue() { return rue; }
    public String getVille() { return ville; }

    @Override
    public String toString() {
        return nomPersonne + " : " + rue + ", " + ville;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }


    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
