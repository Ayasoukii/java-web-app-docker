package com.rst.helloworld.service;

import com.rst.helloworld.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Service
public class HelloWorldService {

    public void insertEmployee() {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO employee(name, role) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "DockerUser");
            ps.setString(2, "Engineer");

            ps.executeUpdate();
            System.out.println("Employee inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDesc() {
        insertEmployee();
        return "Maven + Spring MVC + Jenkins + Docker + MySQL";
    }

    // ✅ MÉTHODE MANQUANTE
    public String getTitle(String name) {
        if (name == null || name.isEmpty()) {
            return "Welcome";
        }
        return "Welcome " + name;
    }
}

