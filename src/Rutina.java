public class Rutina {
    private int id;
    private int idUsuario;
    private String nombre;
    private String descripcion;

    public Rutina(int id, int idUsuario, String nombre, String descripcion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
