package com.test.algorithm;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;

import javax.crypto.Cipher;

public class TestPage {
    static final int KEY_SIZE = 2048;

    public static void main(String[] args) {
        //HashMap<String, String> rsaKeyPair = createKeypairAsString();
        //String publicKey = rsaKeyPair.get("publicKey");
        //String privateKey = rsaKeyPair.get("privateKey");

        //System.out.println("만들어진 공개키:" + publicKey);
        //System.out.println("만들어진 개인키:" + privateKey);

        //String plainText = "플레인 텍스트";
        //System.out.println("평문: " + plainText);

        //String encryptedText = encode(plainText, publicKey);
        //System.out.println("암호화: " + encryptedText);
    	
        //String decryptedText = decode(encryptedText, privateKey);
    	
    	String test = "4a1a9c431f0465e204e9e7e9effd11193e7cb931df16301a3ae5787ee6574abff2a6a539662a71b8456b65ecba606ffd2e3bd603452b6a7e1c4cf5c5be9105fbe4a8ef3a706af5b8688d3588d82ea7a65ae5caedb6a18cd17a2afcb14c84562494c94f168272e3dc7bace5f5d79dd3375d57360a24fb3d30ce092b1ed258f83bafd0555f0ca4b0d78cf9deee452250e4510cb92e1826e175503f44ef21bd81e83eafcdc0582db145bc368eec0d4001dea5021262d17efce198baec2fd532a6dfea3c783b110e92aa87b26db42c3a6cedd83b98056b2e7bc25d423925fecb3ad7e0b23e655d3c18ac3b5b8366f46eccfa9201fd9dd550242ba8ca542598e3bcd1";
    	String privateKey = "639999155452541492180534908812768820916715714188228601819915234795947764898659754447742155937034175978614307907717250430884973419072718504665973940170532439471422877101125460365742537460211153668603305030536060553741038020842882716634807750919270578911511277837145040150834506638703714683915820281964121839984930758888910357247865722286403884791742481909782254378599379223408412362194183200217393882653327818107508876430260674429538436898773890260295162655601372684996269561734855592823313122270831286772660644813634571202633042249617184041405309155469883667142161542797072701026347085301297876278441275044651144525"; 
    	String decryptedText = decode(test, privateKey);
    	
        System.out.println("복호화: " + decryptedText);
    }

    /**
     * 키페어 생성
     */
    static HashMap<String, String> createKeypairAsString() {
        HashMap<String, String> stringKeypair = new HashMap<>();
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(KEY_SIZE, secureRandom);
            KeyPair keyPair = keyPairGenerator.genKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            String stringPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String stringPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            stringKeypair.put("publicKey", stringPublicKey);
            stringKeypair.put("privateKey", stringPrivateKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringKeypair;
    }

    /**
     * 암호화
     */
    static String encode(String plainData, String stringPublicKey) {
        String encryptedData = null;
        try {
            //평문으로 전달받은 공개키를 공개키객체로 만드는 과정
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePublicKey = Base64.getDecoder().decode(stringPublicKey.getBytes());
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytePublicKey);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            //만들어진 공개키객체를 기반으로 암호화모드로 설정하는 과정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            //평문을 암호화하는 과정
            byte[] byteEncryptedData = cipher.doFinal(plainData.getBytes());
            encryptedData = Base64.getEncoder().encodeToString(byteEncryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedData;
    }

    /**
     * 복호화
     */
    static String decode(String encryptedData, String stringPrivateKey) {
        	
    	 String decryptedValue = "";
    	
        try {
        	
        	String decryptedData = null;
        	
            //평문으로 전달받은 개인키를 개인키객체로 만드는 과정
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePrivateKey = Base64.getDecoder().decode(stringPrivateKey.getBytes());
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            //만들어진 개인키객체를 기반으로 암호화모드로 설정하는 과정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            //암호문을 평문화하는 과정
            byte[] byteEncryptedData = Base64.getDecoder().decode(encryptedData.getBytes());
            byte[] byteDecryptedData = cipher.doFinal(byteEncryptedData);
            decryptedData = new String(byteDecryptedData);
            
            //Cipher cipher = Cipher.getInstance("RSA");
            byte[] encryptedBytes = hexToByteArray(stringPrivateKey);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedValue;
    }
    
    public static byte[] hexToByteArray(String hex) {
        
    	if (hex == null || hex.length() % 2 != 0) {
            return new byte[]{};
        }

        byte[] bytes = new byte[hex.length() / 2];
        
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        
        return bytes;
    }
    
}
