package com.zhangruiqiang.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaUtil {

    private static String privateKey="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAj8m5T6WzGFKy5CyBojzzX4wxjQI/bbZe3uieXf2r0OcB1iZIP3HC4oSAqDURoMCtcL/lRZ3yqA4QlbNAr/BOqQIDAQABAkB8TZe2EzlQva2JNDCdYLPE1h3AGUFcR1yct9ywxKvUW5Kj4Mal1WM6UuQuFgry0UwvbnI9Uy44Q58CmQzwCO0BAiEA1myvlN+AiMGDlNMPiogdaVTqm3ZAh9gq5VNcX7R4ll0CIQCrquBHC6nB+W4YSkrKpyZqWZkhampOWRjHm3GhZKG8vQIgIIWTi+zqPdO79VKdxNEoRNWQT8v7tZ7fwrCGDi39LDECIQCXaWPfxf24xRPCAOTu0XcknlpeCsowyIz+obAbtfKh0QIgVRQ055bFb+gNUDriV0VDtAdFR2FJYAlIPHGSLK3I/lw=";
    private static String publicKey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI/JuU+lsxhSsuQsgaI881+MMY0CP222Xt7onl39q9DnAdYmSD9xwuKEgKg1EaDArXC/5UWd8qgOEJWzQK/wTqkCAwEAAQ==";

    public static void main(String[] args) {
        getKey();
        /*String src="zhangruiqinag";
        String sign=sign(src);
        boolean bool=verify(src,sign);
        System.out.println(bool);*/
    }

    public static String sign(String src){



        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));

            KeyFactory keyFactory=KeyFactory.getInstance("RSA");
            PrivateKey privateKey=keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature=Signature.getInstance("MD5withRSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            return Base64.encodeBase64String(signature.sign());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();

        } catch (InvalidKeyException e) {
            e.printStackTrace();

        } catch (SignatureException e) {
            e.printStackTrace();
        }


        return null;

    }

    public static boolean verify(String src,String sign){
        try {
            X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(Base64.decodeBase64(publicKey));

            KeyFactory keyFactory=KeyFactory.getInstance("RSA");
            PublicKey publicKey=keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature=Signature.getInstance("MD5withRSA");
            signature.initVerify(publicKey);
            signature.update(src.getBytes());
            return signature.verify(Base64.decodeBase64(sign));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return  false;

    }

    public static void getKey(){
        try {
            KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair=keyPairGenerator.generateKeyPair();
            PublicKey publicKey =keyPair.getPublic();
            PrivateKey privateKey=keyPair.getPrivate();
            System.out.println(Base64.encodeBase64String(privateKey.getEncoded()));
            System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
