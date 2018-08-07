
package com.malimar.controllers;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESecrp {
    private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] { '@', '$', '*', '?', '!', 's', 't','1', 'e', '~', 'r','%', 't', ')', '(', 'y' };
     public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        byte[] encryptedValue = Base64.getEncoder().encode(encVal);
        return new String(encryptedValue);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}
