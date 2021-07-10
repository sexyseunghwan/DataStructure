package com.test.algorithm;

import java.security.MessageDigest;

public class SHA256 {
	
	public static void main(String[] args) throws Exception {
		
		SHA256 sha = new SHA256();
		
		//String a1 = sha.testSHA256("asd");
		//String a2 = sha.testSHA256("asd");
		
		
		//System.out.println(a1.equals(a2));
		//MessageDigest digest = MessageDigest.getInstance("SHA-256");
		
		//String word = "hellow";
		
		//byte[] hash = digest.digest(word.getBytes("UTF-8"));
		
		//System.out.println(hash);
		
		//String hex = Integer.toHexString(0xff & 'a');
		//System.out.println(hex);
		
		//System.out.println(Integer.toHexString('a'));
		
		//int n = 257;
		
		//System.out.println(Integer.toBinaryString(n));
		
		
		//byte b = (byte)n;
		
		//System.out.println(b);
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		
		String pwd = "aBß";
	
		byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
		
		System.out.println(hash.length);
		String ab = hash.toString();
		System.out.println(ab.length());
		
		
		
//		StringBuffer hexString = new StringBuffer();
//		
//		System.out.println(hash);
//		System.out.println("======================");
//		System.out.println("???");
//		System.out.println(hash.length);
//		System.out.println("???");
//		
//		for (int i = 0; i < hash.length; i++) {
//			
//			String hex = Integer.toHexString(0xff & hash[i]);
//			
//			System.out.println("*********");
//			System.out.println(hex);
//			System.out.println("*********");
//			
//			if(hex.length() == 1) {
//				
//				hexString.append('0');
//			}
//			
//			hexString.append(hex);
//			
//			System.out.println(hexString);
//		}
		
		
		
	}
	
	
	public static String testSHA256(String pwd) {
		
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
			
			StringBuffer hexString = new StringBuffer();
			
			for (int i = 0; i < hash.length; i++) {
				
				String hex = Integer.toHexString(0xff & hash[i]);
				
				if(hex.length() == 1) hexString.append('0');
				
				hexString.append(hex);
			}

			//출력
			return hexString.toString();
			
		} catch(Exception ex){
			
			throw new RuntimeException(ex);
			
		}
		
		
	}
}
