package vn.com.t3h.antino.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordUtils {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    static {
        try {
            // Sử dụng một chuỗi cố định làm secret key (Base64-encoded)
            String secretKeyString = "mySuperSecretKey1234567890123456"; // 32 ký tự
            byte[] keyBytes = secretKeyString.getBytes(StandardCharsets.UTF_8);
            secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing secret key", e);
        }
    }


    public static String encrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting", e);
        }
    }

    public static String decrypt(String encryptedInput) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedInput));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtils.encrypt("admin"));
        System.out.println(PasswordUtils.encrypt("user"));
    }
}
