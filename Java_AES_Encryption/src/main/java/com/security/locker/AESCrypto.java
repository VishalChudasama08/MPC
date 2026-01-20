package com.security.locker;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypto {

    private static final String SECRET = "MySuperSecretKey"; // keep same for encrypt/decrypt

    private static SecretKey getKey() throws Exception {
        byte[] key = SECRET.getBytes("UTF-8");
        return new SecretKeySpec(key, 0, 16, "AES");
    }

    public static byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getKey());
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, getKey());
        return cipher.doFinal(data);
    }
}
