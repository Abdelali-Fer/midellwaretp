/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carnetadresses;

/**
 *
 * @author PcTec
 */
import java.util.ArrayList;
import java.util.List;

public class CarnetAdresses {
    private String nom;
    private List<Adresse> adresses;

    public CarnetAdresses(String nom) {
        this.nom = nom;
        this.adresses = new ArrayList<>();
    }
    
    public void ajouterAdresse(Adresse adresse) {
        adresses.add(adresse);
    }

    public void supprimerAdresse(String nomPersonne) throws AdresseNonTrouveeException {
    Adresse adresse = chercherAdresse(nomPersonne);
    if (adresse == null) {
        throw new AdresseNonTrouveeException("Adresse non trouvée pour " + nomPersonne);
    }
    adresses.remove(adresse);
    }

    public Adresse chercherAdresse(String nomPersonne) {
        return adresses.stream()
                .filter(adresse -> adresse.getNomPersonne().equalsIgnoreCase(nomPersonne))
                .findFirst()
                .orElse(null);
    }

    public List<Adresse> listerAdresses() {
        return adresses;
    }
}
