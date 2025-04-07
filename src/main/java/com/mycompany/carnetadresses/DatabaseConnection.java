/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carnetadresses;

/**
 *
 * @author PcTec
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    public static Connection getConnection() {
        try{
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/carnet_db";  // Remplace par ton URL
            String username = "root";  // Ton nom d'utilisateur MySQL
            String password = "";      // Ton mot de passe MySQL (vide si aucun)
            
            return DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Échec de la connexion !");
        }
    }
}
