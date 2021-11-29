package com.pro.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String MD5Digest(String source){
        String md5= DigestUtils.md5Hex(source);
        return md5;
    }
}
