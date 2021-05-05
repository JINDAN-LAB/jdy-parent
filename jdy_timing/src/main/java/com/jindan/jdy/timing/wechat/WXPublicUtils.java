package com.jindan.jdy.timing.wechat;

public class WXPublicUtils {

    public static boolean verifyUrl(String msgSignature, String timeStamp, String nonce)
            throws AesException {
        String signature = SHA1.getSHA1("jindan", timeStamp, nonce);

        return true;
    }
}
