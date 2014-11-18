package org.gitchina.framework.commons.utils;
public class RandomNumTools {
	/**
	 * 随机数的字符表
	 */
	private static String VALIDATE_CODE_CHAR = "0123456789";
	/**
	 * 随机验证码位数
	 */
	private static int VALIDATE_CODE_LENGTH = 4;

	private static String SEND_POINT_NUM_KEY = "IMG";

	public static String getSendPointNum() {
		// 固定前缀 + 4位随机数字
		String result = SEND_POINT_NUM_KEY;
		for (int i = 0; i < VALIDATE_CODE_LENGTH; i++) {
			int rand = (int) (Math.random() * VALIDATE_CODE_CHAR.toCharArray().length);
			result = result + VALIDATE_CODE_CHAR.charAt(rand);
		}
		return result;
	}

}
