public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String role;  // Atributo para el rol

    // Constructor que incluye el rol
    public Usuario(int id, String nombre, String email, String password, String role) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}