import javax.swing.*;
import java.awt.*;

public class VerPagosWindow {
    public VerPagosWindow() {
        JFrame frame = new JFrame("Ver Pagos");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Ejemplo de datos; en la práctica, carga los pagos con obtenerPagosPorUsuario
        textArea.setText("Listado de pagos:\nPago 1: $50.0 el 2025-01-01\nPago 2: $75.0 el 2025-02-01");

        JButton btnClose = new JButton("Cerrar");
        btnClose.addActionListener(e -> frame.dispose());
        frame.add(btnClose, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
