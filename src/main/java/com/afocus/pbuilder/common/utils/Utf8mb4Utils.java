package com.afocus.pbuilder.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utf8mb4帮助类
 * 
 * 主要解决mysql数据库utf-8类型无法存储4字节长度的utf-8字符问题
 * (4字节长度的字符一般是特殊字符，使用频率很小，甚至一些设备不支持这些字符的显示)<br/>
 * 示例：🍒<br/>
 * 以上字符使用utf-8存储时实际上占用了4个字节：<br/>
 * 11110000 10011111 10001101 10010010<br/>
 * mysql的utf-8格式允许存储的字符最长为3个字节，所以当把字符'🍒'插入到数据库中时会报错
 * (据说Utf8mb4类型支持4字节的字符，但是实验后还是不行，所以写了这个帮助类转义4个字节的字符，
 * 如果在数据库层面解决了utf8的存储问题，那么本类可以很愉快的弃用了)<br/>
 * 
 * 本类提供4个方法：<br/>
 * 1.hasSpecialChar(s)： 用于判断字符串是否包含特殊字符(4字节的字符)，
 * 一般而言普通的文本字段应该阻止这类特殊字符的出现，减小后台处理的压力。<br/>
 * 2.encode(s)：对字符串的特殊字符进行编码，如：'🍒snow🍒'将编码成：'\u0001f352snow\u0001f352'<br/>
 * 3.decode(s)：对字符串的特殊字符进行解码，如：'\u0001f352snow\u0001f352'将解码成：'🍒snow🍒'<br/>
 * 4.filter(s): 过滤特殊字符，把特殊字符都删除掉。如：'🍒snow🍒'过滤后将得到：'snow'<br/>
 * 
 * 此类的应用范围：用户昵称，mysql数据库。在实际应用中（微信用户昵称）出现了大量特殊字符，这些特殊字符不做处理的话将导致用户无法登录系统。<br/>
 * 
 * @author liuwu
 *
 */
public class Utf8mb4Utils {

	/**
	 * 用于补0的数组
	 */
	private static final String[] PREFIX = new String[] { "", "0", "00", "000",
			"0000", "00000", "000000", "0000000" };

	/**
	 * 判断字符串中是否含有特殊字符（UTF-8编码后长度为4字节的字符）
	 * @param s 输入字符串
	 * @return 如果输入字符串含有特殊字符返回true，否则返回false
	 */
	public static boolean hasSpecialChar(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i) > 0xffff) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 过滤，过滤特殊字符
	 * @param s 输入字符串
	 * @return 过滤特殊字符后的字符串
	 */
	public static String filter(String s) {
		if (!hasSpecialChar(s)) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 100);
		for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i) > 0xffff) {
				i++;
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	/**
	 * 编码，对特殊字符进行编码
	 * @param s 输入字符串
	 * @return 编码后的字符串
	 */
	public static String encode(String s) {
		if (!hasSpecialChar(s)) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 100);
		for (int i = 0; i < s.length(); i++) {
			//utf-8存储方案
			//unicode范围                         存储格式                                                         字节数/有效位
			//0x00000000-0x0000007f: 0vvvvvvv                            1字节7个有效位
			//0x00000080-0x000007ff: 110vvvvv 10vvvvvv                   2字节11个有效位
			//0x00000800-0x0000ffff: 1110vvvv 10vvvvvv 10vvvvvv          3字节16个有效位
			//0x00010000-0x01ffffff: 11110vvv 10vvvvvv 10vvvvvv 10vvvvvv 4字节21个有效位
			//我们把存储字节数长度大于3的字符称为特殊字符（即unicode>0xffff）
			if (s.codePointAt(i) > 0xffff) {
				sb.append(toUnicode(s.codePointAt(i)));
				//特殊字符在当前版本的JDK实现里占用了两个字符，所以这里跳过一个。
				//即"🍒".length()==2
				i++;
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private static final Pattern UNICODE_PATTERN = Pattern.compile("\\\\u([0123456789abcdef]{8})");
	/**
	 * 解码，对特殊字符进行解码
	 * @param s 输入字符串
	 * @return 解码后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String s){
		StringBuffer sb = new StringBuffer(s.length());
		Matcher m = UNICODE_PATTERN.matcher(s);
		while (m.find()) {
			String code = m.group(1);
			m.appendReplacement(sb, toSpecialChar(code));
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 把Unicode值转化为16进制表示
	 * @param code Unicode值
	 * @return 16进制表示的Unicode，如： \u0001f352
	 */
	private static String toUnicode(int code) {
		String hex = Integer.toHexString(code);
		return "\\u" + PREFIX[8 - hex.length()] + hex;
	}

	private static String toSpecialChar(String unicode){
		//解码示例
		//特殊字符🍒的编码：       \u0001f352
		//编码的值：                     0001f352
		//转化后的二进制为：       00001 11110011 01010010
		//按照UTF-8的存储格式：11110vvv 10vvvvvv 10vvvvvv 10vvvvvv
		//进行分组：                               000   011111   001101   010010
		//得到🍒的实际存储字节：11110000 10011111 10001101 10010010
		//通过new String(getBytes("\u0001f352"), "utf-8")即可得到特殊字符：🍒
		int code;
		if (unicode.charAt(0) == 'f') {
			String p1 = unicode.substring(0, 4);
			String p2 = unicode.substring(4);
			code = Integer.parseInt(p1, 16) << 16 | Integer.parseInt(p2, 16);
		} else {
			code = Integer.parseInt(unicode, 16);
		}
		byte[] bytes = new byte[] { (byte) (code >>> 18 & 0xf7 | 0xf0),
				(byte) (code >>> 12 & 0xbf | 0x80),
				(byte) (code >>> 6 & 0xbf | 0x80), (byte) (code & 0xbf | 0x80) };
		try {
			return new String(bytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

//	public static void main(String[] args){
//		String s = "♚℡痴人🍒說夢.";
//		System.out.println(encode(s));
//		System.out.println(filter(s));
//	}
}
