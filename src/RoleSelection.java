import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoleSelection {
    public RoleSelection() {
        // Crear ventana para la selección de rol
        JFrame frame = new JFrame("Seleccionar Rol");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes
        JLabel lblSelectRole = new JLabel("Selecciona un Rol:");
        String[] roles = {"Administrador", "Cliente"};
        JComboBox<String> comboBoxRoles = new JComboBox<>(roles);
        JButton btnSelect = new JButton("Seleccionar");

        // Añadir componentes a la ventana
        frame.add(lblSelectRole);
        frame.add(comboBoxRoles);
        frame.add(btnSelect);

        // Acción de seleccionar rol
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRole = (String) comboBoxRoles.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Rol seleccionado: " + selectedRole);
                frame.dispose();  // Cerrar ventana de selección de rol
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}