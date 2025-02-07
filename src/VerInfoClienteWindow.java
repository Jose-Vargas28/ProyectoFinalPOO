import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerInfoClienteWindow {
    public VerInfoClienteWindow() {
        // Crear ventana para ver la información del cliente
        JFrame frame = new JFrame("Ver Información del Cliente");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblInfo = new JLabel("Información del Cliente:");
        JTextArea taInfo = new JTextArea(10, 30);
        taInfo.setText("Aquí se mostrará la información del cliente.");
        taInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taInfo);

        // Botón para cerrar
        JButton btnClose = new JButton("Cerrar");

        // Añadir componentes a la ventana
        frame.add(lblInfo);
        frame.add(scrollPane);
        frame.add(btnClose);

        // Acción de cerrar
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
