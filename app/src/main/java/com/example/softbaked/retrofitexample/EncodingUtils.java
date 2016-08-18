package com.example.softbaked.retrofitexample;

import com.example.softbaked.retrofitexample.api.time.model.ServerTimeGson;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

/**
 * Created by softbaked on 8/18/16 AD.
 */
public class EncodingUtils {

    public static String parseToMd5(ServerTimeGson data) throws ParseException {
        String serverTime = data.getServerTime();
        return md5Hashing(serverTime);
    }

    private static String md5Hashing(String serverTime) {
        String test = "elims" + serverTime;
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        if (m != null) {
            m.update(test.getBytes(), 0, test.length());
            return new BigInteger(1, m.digest()).toString(16);
        } else {
            return null;
        }
    }

}
