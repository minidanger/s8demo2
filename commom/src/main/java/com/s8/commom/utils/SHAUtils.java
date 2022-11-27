package com.s8.commom.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
public class SHAUtils {
    private static final String KEY_SHA = "SHA";

    public static BigInteger encodeSHA(String content){
        byte[] inputData = content.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            BigInteger sha = new BigInteger(messageDigest.digest());
            return sha;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
