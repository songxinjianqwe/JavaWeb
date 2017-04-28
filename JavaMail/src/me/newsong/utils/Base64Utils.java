package me.newsong.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {

	public static String encode(String str, String charset) {
		try {
			byte[] bytes = str.getBytes(charset);
			bytes = Base64.encodeBase64(bytes);
			return new String(bytes, charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String decode(String str, String charset) {
		try {
			byte[] bytes = str.getBytes(charset);
			bytes = Base64.decodeBase64(bytes);
			return new String(bytes, charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String encode(String s) {
		return encode(s, "utf-8");
	}

	public static String decode(String s) {
		return decode(s, "utf-8");
	}

}
