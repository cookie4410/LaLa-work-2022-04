package util;

public class Validate {
	/**
	 * 数字の文字列を自然数に変換する。
	 * @param numtxt -- 数字の文字列
	 * @return 成功: int型の自然数<br>
	 * 			失敗: -1
	 */
	public static int getNumber(String numtxt) {
		int num = 0;
		try {
			num = Integer.parseInt(numtxt);
		} catch (NumberFormatException e) {
			num = -1;
		}
		return num;
	}
}
