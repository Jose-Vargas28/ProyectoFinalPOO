import javax.swing.*;
import java.awt.*;

public class VerProductosWindow {
    public VerProductosWindow() {
        JFrame frame = new JFrame("Ver Productos");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Por ejemplo, usar datos de prueba
        textArea.setText("Listado de productos:\nProducto 1 - $10.0\nProducto 2 - $20.0");

        JButton btnClose = new JButton("Cerrar");
        btnClose.addActionListener(e -> frame.dispose());
        frame.add(btnClose, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
