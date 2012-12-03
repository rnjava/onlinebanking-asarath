package com.openbank.onlinebanking.util;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GuidUtil {

	private static Logger log = LoggerFactory.getLogger(GuidUtil.class);
	
    public static String generateGuid (){
        return UUID.randomUUID().toString().toUpperCase();
    }
    
    
    
    
//	public static String generateMD5Hash(String plainText) {
//		StringBuffer sb = new StringBuffer();
//		if (plainText != null) {
//			MessageDigest md = null;
//
//			try {
//				md = MessageDigest.getInstance("md5");
//			} catch (NoSuchAlgorithmException e) {
//				log.info(e.getMessage());
//			}
//			md.update(plainText.getBytes());
//			byte byteData[] = md.digest();
//			for (int i = 0; i < byteData.length; i++) {
//				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
//						.substring(1));
//			}
//		}
//		return sb.toString();
//	}
	
	
	public static void main(String a[]) {
		System.out.println(generateGuid());
	}
}
