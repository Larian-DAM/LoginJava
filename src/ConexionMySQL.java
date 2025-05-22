
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    public static Connection getConnection() {
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/seguridad_db"; // Cambia
        String usuario = "root"; // Cambia 'root' si usas otro usuario

        String contraseña = "root"; // Cambia '' por tu contraseña
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("CONECTADO CORRECTAMENTE");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL CARGAR EL DRIVER JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR A LA BASE DE DATOS: " + e.getMessage());
        }
        return conexion;
    }
}
