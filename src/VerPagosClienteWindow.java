import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerPagosClienteWindow {
    public VerPagosClienteWindow() {
        // Crear ventana para ver los pagos del cliente
        JFrame frame = new JFrame("Ver Pagos del Cliente");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblPagos = new JLabel("Pagos del Cliente:");
        JTextArea taPagos = new JTextArea(10, 30);
        taPagos.setText("Aquí se mostrarán los pagos realizados.");
        taPagos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taPagos);

        // Botón para cerrar
        JButton btnClose = new JButton("Cerrar");

        // Añadir componentes a la ventana
        frame.add(lblPagos);
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
