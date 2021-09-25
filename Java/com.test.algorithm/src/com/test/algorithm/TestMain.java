package com.test.algorithm;

import java.security.MessageDigest;

public class TestMain {
	
	public static void main(String[] args) {
		
		try{
			
			String pw = "1234&^5&";
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pw.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			//출력
			System.out.println(hexString.toString());
			
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}

	}
}
