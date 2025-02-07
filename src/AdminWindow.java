import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow {
    public AdminWindow() {
        // Crear ventana de administrador
        JFrame frame = new JFrame("Panel de Administrador");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel para los botones de operaciones
        JPanel panelButtons = new JPanel();
        JButton btnVerUsuarios = new JButton("Ver Usuarios");
        JButton btnVerProductos = new JButton("Ver Productos");
        JButton btnVerPagos = new JButton("Ver Pagos");
        JButton btnVerRutinas = new JButton("Ver Rutinas");
        JButton btnAñadirUsuario = new JButton("Añadir Usuario");

        panelButtons.add(btnVerUsuarios);
        panelButtons.add(btnVerProductos);
        panelButtons.add(btnVerPagos);
        panelButtons.add(btnVerRutinas);
        panelButtons.add(btnAñadirUsuario);

        // Añadir panel de botones a la ventana
        frame.add(panelButtons, BorderLayout.NORTH);

        // Acción de "Ver Usuarios"
        btnVerUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerUsuariosWindow(); // Ventana para ver todos los usuarios
            }
        });

        // Acción de "Ver Productos"
        btnVerProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerProductosWindow(); // Ventana para ver productos
            }
        });

        // Acción de "Ver Pagos"
        btnVerPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerPagosWindow(); // Ventana para ver pagos
            }
        });

        // Acción de "Ver Rutinas"
        btnVerRutinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerRutinasWindow(); // Ventana para ver rutinas
            }
        });

        // Acción de "Añadir Usuario"
        btnAñadirUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserWindow(); // Ventana para añadir nuevos usuarios
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
