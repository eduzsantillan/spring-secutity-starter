package isi.pe.security_service.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class SecureKeyGenerator {

    public static String getKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[32]; // 256-bit key
        secureRandom.nextBytes(keyBytes);
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated Key: " + base64Key);
        return base64Key;
    }
}
