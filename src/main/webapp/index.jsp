<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.mycompany.carnetadresses.Adresse" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Récupérer la liste des adresses à afficher
    List<Adresse> adresses = (List<Adresse>) request.getAttribute("adresses");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Carnet d'Adresses</title>
</head>
<body>
    <h2>Ajouter une adresse</h2>
    <form action="CarnetServlet" method="post">
        Nom: <input type="text" name="nom" required><br>
        Rue: <input type="text" name="rue" required><br>
        Ville: <input type="text" name="ville" required><br>
        <button type="submit">Ajouter</button>
    </form>

    <h2>Supprimer une adresse</h2>
    <form action="CarnetServlet" method="post">
        <input type="hidden" name="action" value="supprimer">
        Nom: <input type="text" name="nom" required><br>
        <button type="submit">Supprimer</button>
    </form>

    <h2>Liste des Adresses</h2>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Rue</th>
            <th>Ville</th>
        </tr>
        <!-- Affichage dynamique des adresses -->
        <c:forEach var="adresse" items="${adresses}">
            <tr>
                <td>${adresse.nomPersonne}</td>
                <td>${adresse.rue}</td>
                <td>${adresse.ville}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
