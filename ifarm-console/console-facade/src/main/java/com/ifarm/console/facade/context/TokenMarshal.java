package com.ifarm.console.facade.context;

import org.apache.commons.codec.binary.Base64;


/**
 * 令牌序列化与反序列化
 */
final public class TokenMarshal {
	private TokenMarshal(){
	}

	/**
	 * 序列化(Base64编码)
	 */
	public static String marshal(Token token) {
		return new String(Base64.encodeBase64String(token.toBytes()));
	}

	/**
	 * 反序列化（Base64解码）
	 */
	public static Token unMarshal(String tokenStr) {
		return new Token(Base64.decodeBase64(tokenStr));
	}


}
