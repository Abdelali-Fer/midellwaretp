/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carnetadresses;

/**
 *
 * @author PcTec
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresseDAO {
    
    public List<Adresse> getAllAddresses() {
    List<Adresse> adresses = new ArrayList<>();
    String sql = "SELECT * FROM adresse";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            // Utilisation du constructeur avec paramètres
            String nom = rs.getString("nom");
            String rue = rs.getString("rue");
            String ville = rs.getString("ville");

            // Création de l'objet Adresse avec le constructeur
            Adresse adresse = new Adresse(nom, rue, ville);
            adresse.setId(rs.getInt("id")); // Si tu as un setter pour l'ID
            adresses.add(adresse);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return adresses;
}
    
    public void addAddress(Adresse adresse) {
        String sql = "INSERT INTO adresse (nom, rue, ville) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, adresse.getNomPersonne());
            stmt.setString(2, adresse.getRue());
            stmt.setString(3, adresse.getVille());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAddress(int id) {
        String sql = "DELETE FROM adresse WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Adresse getAddressByNom(String nom) {
    String sql = "SELECT * FROM adresse WHERE nom = ?";
    Adresse adresse = null;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nom);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Utilisation du constructeur avec paramètres
            String rue = rs.getString("rue");
            String ville = rs.getString("ville");

            // Création de l'objet Adresse avec le constructeur
            adresse = new Adresse(nom, rue, ville);
            adresse.setId(rs.getInt("id")); // Ajout de l'ID si nécessaire
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return adresse;
}

    public void addAdresse(Adresse adresse) {
    String sql = "INSERT INTO adresse (nom, rue, ville) VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, adresse.getNomPersonne());
        stmt.setString(2, adresse.getRue());
        stmt.setString(3, adresse.getVille());

        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void deleteAdresseByNom(String nom) throws AdresseNonTrouveeException {
    String sql = "DELETE FROM adresse WHERE nom = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nom);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected == 0) {
            throw new AdresseNonTrouveeException("Adresse avec le nom " + nom + " non trouvée.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
}
