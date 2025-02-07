import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteWindow {
    public ClienteWindow() {
        // Crear ventana de cliente
        JFrame frame = new JFrame("Panel de Cliente");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel para los botones de operaciones
        JPanel panelButtons = new JPanel();
        JButton btnVerInfo = new JButton("Ver Información");
        JButton btnVerPagos = new JButton("Ver Pagos");
        JButton btnVerRutinas = new JButton("Ver Rutinas");

        panelButtons.add(btnVerInfo);
        panelButtons.add(btnVerPagos);
        panelButtons.add(btnVerRutinas);

        // Añadir panel de botones a la ventana
        frame.add(panelButtons, BorderLayout.NORTH);

        // Acción de "Ver Información"
        btnVerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerInfoClienteWindow(); // Nueva ventana para ver información del cliente
            }
        });

        // Acción de "Ver Pagos"
        btnVerPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerPagosClienteWindow(); // Nueva ventana para ver pagos del cliente
            }
        });

        // Acción de "Ver Rutinas"
        btnVerRutinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerRutinasClienteWindow(); // Nueva ventana para ver rutinas del cliente
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
