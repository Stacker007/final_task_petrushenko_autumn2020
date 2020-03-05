package by.simplypvs.servlets;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
    private static String md5ApacheExample(String text){
        return DigestUtils.md5Hex(text);
    }

    public static void main(String[] args) {
        System.out.println(md5ApacheExample("17857"));
    }
}
