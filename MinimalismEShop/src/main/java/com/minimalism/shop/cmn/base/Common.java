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
	
	public static <E> boolean checkNullandBlank(E e){
		if(e== null || e.equals("")){
			return true;
		}
		return false;
	}
	
	public static <E> boolean checkListNullandBlank(List<E> e){
		if(e==null || e.isEmpty()){
			return true;
		}
		return false;
	}

	public static int tinhGiaithua(int n) {

		int ketqua = 1;
		int i;
		for (i = 2; i <= n; i++) {
			ketqua *= i;
		}
		return ketqua;
	}

	public static int tinhTohop(int k, int n) {

		return tinhGiaithua(n) / (tinhGiaithua(k) * tinhGiaithua(n - k));

	}
}
