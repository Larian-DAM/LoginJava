/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CreateDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luiss
 */

public class ConexionMySQL {

    public static Connection getConnection() {
        // Variables con los datos de la conexión.
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";

        try {
            // Carga el driver de MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Se conecta al MySQL.
            connection = DriverManager.getConnection(url, user, password);
            // Mensaje de confirmación.
            System.out.println("CONEXION A LA BASE DE DATOS CORRECTA");
        } catch (ClassNotFoundException e) {
            // Mensaje de error de driver.
            System.err.println("ERROR AL CARGAR EL DRIVER JDBC: " + e.getMessage());
        } catch (SQLException e) {
            // Mensaje de error al conectar al MySQL.
            System.err.println("ERROR AL CONECTAR A LA BASE DE DATOS: " + e.getMessage());
        }
        return connection;
    }
}
