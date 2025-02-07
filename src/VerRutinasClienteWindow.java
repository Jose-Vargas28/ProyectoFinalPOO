import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerRutinasClienteWindow {
    public VerRutinasClienteWindow() {
        // Crear ventana para ver las rutinas del cliente
        JFrame frame = new JFrame("Ver Rutinas del Cliente");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblRutinas = new JLabel("Rutinas del Cliente:");
        JTextArea taRutinas = new JTextArea(10, 30);
        taRutinas.setText("Aquí se mostrarán las rutinas asignadas.");
        taRutinas.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taRutinas);

        // Botón para cerrar
        JButton btnClose = new JButton("Cerrar");

        // Añadir componentes a la ventana
        frame.add(lblRutinas);
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
