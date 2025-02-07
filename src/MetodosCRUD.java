import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetodosCRUD {

    // Obtener un usuario por email (lo que faltaba para el login)
    public static Usuario obtenerUsuarioPorEmail(String email) {
        Connection con = Conexion.getConexion();
        Usuario usuario = null;
        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            return usuario;
        }
        try {
            String query = "SELECT * FROM usuarios WHERE email = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("email");
                String password = rs.getString("password");
                usuario = new Usuario(id, nombre, correo, password);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return usuario;
    }

    // Métodos CRUD para pagos
    public static boolean registrarPago(int idUsuario, double monto, String fecha) {
        Connection con = Conexion.getConexion();
        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            return false;
        }
        try {
            String query = "INSERT INTO pagos (id_usuario, monto, fecha) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            stmt.setDouble(2, monto);
            stmt.setString(3, fecha);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar pago: " + e.getMessage());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // Obtener pagos por usuario
    public static List<Pago> obtenerPagosPorUsuario(int idUsuario) {
        Connection con = Conexion.getConexion();
        List<Pago> pagos = new ArrayList<>();
        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            return pagos;
        }
        try {
            String query = "SELECT * FROM pagos WHERE id_usuario = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idPago = rs.getInt("id");
                double monto = rs.getDouble("monto");
                String fecha = rs.getString("fecha");
                pagos.add(new Pago(idPago, idUsuario, monto, fecha));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener pagos: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return pagos;
    }

    // Métodos CRUD para rutinas
    public static boolean registrarRutina(int idUsuario, String nombre, String descripcion) {
        Connection con = Conexion.getConexion();
        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            return false;
        }
        try {
            String query = "INSERT INTO rutinas (id_usuario, nombre, descripcion) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar rutina: " + e.getMessage());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // Obtener rutinas de un usuario
    public static List<Rutina> obtenerRutinasPorUsuario(int idUsuario) {
        Connection con = Conexion.getConexion();
        List<Rutina> rutinas = new ArrayList<>();
        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            return rutinas;
        }
        try {
            String query = "SELECT * FROM rutinas WHERE id_usuario = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idRutina = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                rutinas.add(new Rutina(idRutina, idUsuario, nombre, descripcion));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener rutinas: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return rutinas;
    }

    // Métodos CRUD para productos
    public static boolean registrarProducto(String nombre, double precio) {
        Connection con = Conexion.getConexion();
        if (con == null) {
            System.out.println("Error: No se pudo establecer la conexión con la base de datos.");
            return false;
        }
        try {
            String query = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e.getMessage());
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

