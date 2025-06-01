package CreateDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luiss
 */
public class CreacionDB {

    public static void main(String[] args) {
        Connection connection = ConexionMySQL.getConnection();
        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();

                // Crea la base de datos si no existe y confirma la creación.
                String sqlCreateSQL = "CREATE DATABASE IF NOT EXISTS seguridad_db";
                stmt.executeUpdate(sqlCreateSQL);
                System.out.println("BASE DE DATOS CREADA");

                // Se conecta a la base de datos y confirma la conexión.
                stmt.executeUpdate("USE seguridad_db");
                System.out.println("CONEXION A LA BASE DE DATOS EXITOSA");

                // Crea la tabla y confirma la creación.
                String sqlCreateTb = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) NOT NULL, password VARCHAR(100) NOT NULL)";
                stmt.executeUpdate(sqlCreateTb);
                System.out.println("TABLA CREADA");

                // Realiza la insercción de la información y confirma la inserción.
                String sqlInsert = "INSERT INTO users (username, password) VALUES ('admin', 'admin123'), ('usuario', 'pass123')";
                stmt.executeUpdate(sqlInsert);
                System.out.println("USUARIOS INSERTADOS");

            } catch (SQLException ex) {
                // Mensaje de error al crear la base de datos.
                System.err.println("ERROR DURANTE LA CREACION DE LA BASE DE DATOS: " + ex.getMessage());
            }
        }
    }
}
