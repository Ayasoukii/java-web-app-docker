package com.rst.helloworld.web;

import com.rst.helloworld.db.DBConnection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

@Component
public class AutoInsertEmployee {

    private static final String[] NOMS = {
            "Ali", "Sami", "Amine", "Mohamed", "Karim", "Aya", "Nour"
    };

    private static final String[] PRENOMS = {
            "Ben Salah", "Trabelsi", "Karray", "souki", "Gharbi"
    };

    private static final String[] VILLES = {
            "Tunis", "Sfax", "Sousse", "Monastir", "Nabeul"
    };

    private final Random random = new Random();

    /**
     * Insertion automatique toutes les 30 secondes
     */
    @Scheduled(fixedRate = 30000)
    public void insertEmployeeAutomatically() {

        String nom = NOMS[random.nextInt(NOMS.length)];
        String prenom = PRENOMS[random.nextInt(PRENOMS.length)];
        String ville = VILLES[random.nextInt(VILLES.length)];

        String sql = "INSERT INTO employe (nom, prenom, ville) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, ville);

            ps.executeUpdate();

            System.out.println(
                "[AUTO-INSERT] Employé ajouté : "
                + nom + " " + prenom + " | Ville : " + ville
            );

        } catch (Exception e) {
            System.err.println("[AUTO-INSERT] Erreur lors de l'insertion");
            e.printStackTrace();
        }
    }
}
