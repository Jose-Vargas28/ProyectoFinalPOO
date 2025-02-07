import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserWindow {
    public AddUserWindow() {
        JFrame frame = new JFrame("Añadir Usuario");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(20);
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField(20);
        JLabel lblRole = new JLabel("Rol:");
        // Usamos un JComboBox para seleccionar el rol
        String[] roles = {"admin", "cliente"};
        JComboBox<String> comboRole = new JComboBox<>(roles);

        JButton btnAdd = new JButton("Añadir Usuario");

        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblEmail);
        frame.add(txtEmail);
        frame.add(lblPassword);
        frame.add(txtPassword);
        frame.add(lblRole);
        frame.add(comboRole);
        frame.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());
                String role = (String) comboRole.getSelectedItem();

                // Cifrar la contraseña (si es necesario) y registrar el usuario
                String encryptedPassword = SecurityUtil.encryptPassword(password);
                boolean success = MetodosCRUD.registrarUsuario(nombre, email, encryptedPassword, role);

                if (success) {
                    JOptionPane.showMessageDialog(frame, "Usuario añadido correctamente.");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Error al añadir usuario.");
                }
            }
        });

        frame.setVisible(true);
    }
}
