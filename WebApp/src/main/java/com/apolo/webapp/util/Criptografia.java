package com.apolo.webapp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author raybm
 */
public class Criptografia {

    public static String getKey() throws Exception {
        String chave = "";
        Random ra = new Random();
        int valor = 0;
        for (int i = 0; i < 5; i++) {
            valor = (65 + ra.nextInt(90 - 65));
            chave += String.valueOf((char)valor);
        }
        for (int i = 0; i < 5; i++) {
            valor = ra.nextInt(10);
            chave += String.valueOf(valor);
        }
        return chave;
    }
    
    public static String criptografarSHA1(String senha) throws Exception {
       return sha1(senha);
    }
    
    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
 
}
