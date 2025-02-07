import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWindow {
    public RegisterWindow() {
        // Crear ventana de registro
        JFrame frame = new JFrame("Registro de Usuario");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblTitle = new JLabel("Crear Cuenta");
        JLabel lblName = new JLabel("Nombre:");
        JTextField tfName = new JTextField(20);
        JLabel lblEmail = new JLabel("Correo Electrónico:");
        JTextField tfEmail = new JTextField(20);
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField pfPassword = new JPasswordField(20);
        JLabel lblConfirmPassword = new JLabel("Confirmar Contraseña:");
        JPasswordField pfConfirmPassword = new JPasswordField(20);
        JButton btnRegister = new JButton("Registrar");

        // Añadir componentes a la ventana
        frame.add(lblTitle);
        frame.add(lblName);
        frame.add(tfName);
        frame.add(lblEmail);
        frame.add(tfEmail);
        frame.add(lblPassword);
        frame.add(pfPassword);
        frame.add(lblConfirmPassword);
        frame.add(pfConfirmPassword);
        frame.add(btnRegister);

        // Acción para registrar el usuario
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados
                String name = tfName.getText();
                String email = tfEmail.getText();
                String password = new String(pfPassword.getPassword());
                String confirmPassword = new String(pfConfirmPassword.getPassword());

                // Validar los campos
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden.");
                } else {
                    // Cifrar la contraseña
                    String encryptedPassword = SecurityUtil.encryptPassword(password);

                    // Llamar a la operación de registro con la contraseña cifrada
                    boolean success = MetodosCRUD.registrarUsuario(name, email, encryptedPassword);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Usuario registrado correctamente.");
                        frame.setVisible(false); // Cierra la ventana de registro
                        new Login(); // Regresa a la ventana de Login
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error al registrar usuario.");
                    }
                }
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

