import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VerUsuariosWindow {
    public VerUsuariosWindow() {
        JFrame frame = new JFrame("Ver Usuarios");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Cargar usuarios desde la base de datos
        List<Usuario> usuarios = MetodosCRUD.obtenerUsuarios();
        StringBuilder sb = new StringBuilder();
        for (Usuario u : usuarios) {
            sb.append("ID: ").append(u.getId())
                    .append(" - Nombre: ").append(u.getNombre())
                    .append(" - Email: ").append(u.getEmail())
                    .append(" - Rol: ").append(u.getRole())
                    .append("\n");
        }
        textArea.setText(sb.toString());

        JButton btnClose = new JButton("Cerrar");
        btnClose.addActionListener(e -> frame.dispose());
        frame.add(btnClose, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
