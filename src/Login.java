import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public Login() {
        // Crear ventana principal
        JFrame frame = new JFrame("FitTrackHub - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Componentes de la ventana
        JLabel lblWelcome = new JLabel("Bienvenido a FitTrackHub");
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField(20);
        JButton btnLogin = new JButton("Acceder al Sistema");
        JButton btnRegister = new JButton("Registrarse");

        // Añadir componentes a la ventana
        frame.add(lblWelcome);
        frame.add(lblEmail);
        frame.add(txtEmail);
        frame.add(lblPassword);
        frame.add(txtPassword);
        frame.add(btnLogin);
        frame.add(btnRegister);

        // Acción de Acceder al Sistema
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());

                // Verificar si las credenciales son correctas
                if (loginUsuario(email, password)) {
                    // Si el login es exitoso, se redirige según el rol
                    String rol = obtenerRolUsuario(email);  // Obtenemos el rol del usuario
                    if ("admin".equals(rol)) {
                        new AdminWindow();  // Redirige a la ventana de administrador
                    } else if ("cliente".equals(rol)) {
                        new ClienteWindow();  // Redirige a la ventana de cliente
                    }
                    frame.dispose();  // Cierra la ventana de login
                } else {
                    JOptionPane.showMessageDialog(frame, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción de Registrarse
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterWindow(); // Abre la ventana de registro
                frame.dispose(); // Cierra la ventana de login
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }

    // Método para verificar si el usuario existe y las credenciales son correctas
    private boolean loginUsuario(String email, String password) {
        Usuario usuario = MetodosCRUD.obtenerUsuarioPorEmail(email);
        if (usuario != null) {
            String storedPassword = usuario.getPassword();
            return SecurityUtil.encryptPassword(password).equals(storedPassword);
        }
        return false;
    }

    // Método para obtener el rol del usuario
    private String obtenerRolUsuario(String email) {
        Usuario usuario = MetodosCRUD.obtenerUsuarioPorEmail(email);
        if (usuario != null) {
            return usuario.getRole();
        }
        return null;
    }
}
