import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
    // Método para cifrar la contraseña con SHA-256
    public static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();  // Devuelve la contraseña cifrada en hexadecimal
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
