package com.geekhub.converter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConvertUtils {
    public static String getHashMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger bi = new BigInteger(1, md.digest(text.getBytes()));
        return bi.toString(16);
    }
}
