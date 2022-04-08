package dev.blockbuster.cypher;

public class CaesarEncrypt {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     *
     * @param key to encrypt
     * @param plainText value
     * @return encrypted text
     * Encrypt a given string, by replacing each letter with
     *
     */
    public static String encrypt(String plainText, int key) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {
                int idx = alphabet.indexOf(Character.toLowerCase(ch));
                idx = (idx + key) % 26;
                if (Character.isUpperCase(ch)) {
                    cipherText.append(Character.toUpperCase(alphabet.charAt(idx)));
                } else {
                    cipherText.append(alphabet.charAt(idx));
                }
            } else {
                cipherText.append(ch);
            }
        }
        return cipherText.toString();
    }

    /**
     *
     * @param text
     * @return decrypted text
     *
     * Decrypt a given string by using the Caesar Cypher.
     */
    public static String decrypt(String text) {
        text = text.toLowerCase();
        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' ') {
                plain.append(' ');
            } else {
                int charPosition = alphabet.indexOf(text.charAt(i));
                int val = (charPosition - 3) % alphabet.length();
                char valuedReplaced = alphabet.charAt(val);

                plain.append(valuedReplaced);
            }
        }

        return plain.toString();
    }
 }
