package dev.blockbuster.cypher;

public class VignereCypher {

    /**
     * This method generates a key in cyclic way, until
     * it's length isn't equal to the length of
     * the original one.
     * @param string
     * @param key
     * @return key
     */
    public static String generateKey(String string, String key) {
        int length = key.length();

        StringBuilder keyBuilder = new StringBuilder(key);
        for (int i = 0; ; i++) {
            if (length == i) {
                i = 0;
            } else if (keyBuilder.length() == string.length()) {
                break;
            }

            keyBuilder.append(keyBuilder.charAt(i));
        }
        key = keyBuilder.toString();

        return key;
    }

    /**
     * This method returns the encrypted text generated
     * with the help of the key
     * @param string
     * @param key
     * @return encrypted text
     */
    public static String encryptText(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            //Converting in range 0-25
            int x = text.charAt(i) + key.charAt(i);

            //convert into ASCII alphabet
            x += 'A';
            encryptedText.append((char) x);
        }

        return encryptedText.toString();
    }

    /**
     * This method returns the decrypted text generated
     * and returns the original message
     * @param string
     * @param key
     * @return original message
     */
    public static String decryptEncryptedText(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length() && i < key.charAt(i); i++) {
            //Converting in range 0-25
            int x = (encryptedText.charAt(i) - key.charAt(i) + 26) % 26;

            //convert into ASCII alphabet
            x += 'A';
            decryptedText.append((char) x);
        }

        return decryptedText.toString();
    }
}
