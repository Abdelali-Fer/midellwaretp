/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.carnetadresses;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PcTec
 */
@WebServlet(name = "CarnetServlet", urlPatterns = {"/CarnetServlet"})
public class CarnetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static CarnetAdresses carnet = new CarnetAdresses("Mon Carnet");
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarnetServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarnetServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Création d'un objet AdresseDAO
    AdresseDAO adresseDAO = new AdresseDAO();
    
    // Récupération des adresses à l'aide de la méthode getAllAddresses()
    List<Adresse> adresses = adresseDAO.getAllAddresses(); 

    // Ajouter les adresses à l'attribut de requête pour les passer à la vue JSP
       request.setAttribute("adresses", adresses);
    
    // Rediriger vers la page index.jsp pour afficher les adresses
    request.getRequestDispatcher("/index.jsp").forward(request, response);
}


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    // Récupérer l'action du formulaire (ajouter ou supprimer)
    String action = request.getParameter("action"); // Peut être null ou "supprimer"
    String nom = request.getParameter("nom");
    
    // Initialiser AdresseDAO
    AdresseDAO adresseDAO = new AdresseDAO();
    
    if ("supprimer".equals(action)) {
        // Supprimer une adresse
        try {
            // Appeler la méthode supprimerAdresse() du DAO pour supprimer une adresse par son nom
            adresseDAO.deleteAdresseByNom(nom);
            System.out.println("Adresse supprimée pour : " + nom);
        } catch (AdresseNonTrouveeException e) {
            e.printStackTrace(); // Gérer l'erreur si l'adresse n'est pas trouvée
            // Tu peux aussi stocker un message d'erreur pour l'afficher dans la JSP
        }
    } else {
        // Par défaut, on considère que c'est un ajout
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        
        // Ajouter l'adresse à la base de données
        Adresse adresse = new Adresse(nom, rue, ville);
        adresseDAO.addAdresse(adresse);
        System.out.println("Adresse ajoutée : " + nom + ", " + rue + ", " + ville);
    }

    doGet(request, response);
}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
