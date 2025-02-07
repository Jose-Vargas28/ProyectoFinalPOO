public class Pago {
    private int id;
    private int idUsuario;
    private double monto;
    private String fecha;

    public Pago(int id, int idUsuario, double monto, String fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }
}
