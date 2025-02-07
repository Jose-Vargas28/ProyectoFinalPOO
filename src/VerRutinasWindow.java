import javax.swing.*;
import java.awt.*;

public class VerRutinasWindow {
    public VerRutinasWindow() {
        JFrame frame = new JFrame("Ver Rutinas");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Datos de prueba; en la práctica, usar MetodosCRUD.obtenerRutinasPorUsuario
        textArea.setText("Listado de rutinas:\nRutina 1: Cardio y Fuerza\nRutina 2: Yoga y Flexibilidad");

        JButton btnClose = new JButton("Cerrar");
        btnClose.addActionListener(e -> frame.dispose());
        frame.add(btnClose, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
