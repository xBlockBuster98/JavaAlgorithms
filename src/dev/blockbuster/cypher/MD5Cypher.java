package dev.blockbuster.cypher;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Cypher {

    /**
     * Encrypts a string using MD5 encryption mode, very used in the internet.
     * @param string
     * @return cypher string
     * @throws NoSuchAlgorithmException
     */
    public String encryptString(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] digest = messageDigest.digest();
        BigInteger bigInt = new BigInteger(1, digest);

        //Converts string into hex value
        StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
        while(hashtext.length() < 32 ){
            hashtext.insert(0, "0");
        }

        return hashtext.toString();
    }
}
