package dev.blockbuster.cypher;

import java.util.Base64;

public class Base64Cypher {
    /**
     * Encrypt the original message
     * @param plainText
     * @return
     */
    public static String encryptString(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    /**
     * Decrypt the encoded text
     * @param cypherText
     * @return original message
     */
    public static String decryptString(String cypherText) {
        byte[] orginalMess = Base64.getDecoder().decode(cypherText);
        return new String(orginalMess);
    }
}
