import java.sql.*;

public class Conexion {
    private static Connection connection = null;

    public static Connection getConexion() {
        if (connection == null) {
            try {
                // Configuración de la conexión a la base de datos
                String url = "jdbc:mysql://localhost:3306/GYM";
                String user = "root";  // Ajusta esto según tu configuración
                String password = "root";  // Ajusta esto según tu configuración

                // Establecer conexión
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConexion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}