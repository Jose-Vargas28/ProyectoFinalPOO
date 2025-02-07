import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Asegurarse de que la UI se ejecute en el hilo adecuado de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login(); // Llama la clase Login al iniciar el programa
            }
        });
    }
}