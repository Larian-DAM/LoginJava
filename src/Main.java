
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection conexion = ConexionMySQL.getConnection();
        if (conexion != null) {
            System.out.println("\n--------------------------");
            System.out.println("BIENVENIDO A MI APLICATIVO");
            System.out.println("--------------------------\n");
            
            Scanner inputName = new Scanner(System.in);
            System.out.print("Usuario: ");
            String userName = inputName.nextLine();
            
            Scanner inputPasswd = new Scanner(System.in);
            System.out.print("Contraseña: ");
            String userPasswd = inputName.nextLine();
            
        try {
            String consultaSQL = "SELECT * FROM users WHERE username = '" + userName + "' AND password = '" + userPasswd + "'";
            System.out.println("\nConsulta realiada: " + consultaSQL);

            // Ejecutar consulta

            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);

            // Verifica si hay coincidencia y devuelve true en dicho caso

            if (rs.next()) {
                System.out.println("INICIO DE SESION CORRECTO");
            } else {
                System.out.println("USUARIO O CONTRASEÑA INCORRECTOS");
            }
            
            if (conexion != null) {
                conexion.close();
                System.out.println("CONEXION CERRADA CORRECTAMENTE");
            }
        } catch (SQLException e) {
            System.err.println("ERROR AL CERRAR LA CONEXION: " + e.getMessage());
        }
        }

    }
}
