package com.minimalism.shop.cmn.base;

import java.security.MessageDigest;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class Common {
	public static String passEncode(String password, int salt){
		password += salt;
		password = getMD5(password);
		return password;
	}

	private static String getMD5(String pass) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(pass.getBytes());
			byte[] by = digest.digest();
			String newPass = DatatypeConverter.printHexBinary(by).toLowerCase();
			return newPass;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean checkNullandBlank(Object object){
		if(object== null || object.equals("")){
			return true;
		}
		return false;
	}
	
	public static boolean checkListNullandBlank(List<Object> list){
		if(list==null || list.isEmpty()){
			return true;
		}
		return false;
	}

}
