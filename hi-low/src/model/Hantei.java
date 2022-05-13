package model;

public class Hantei {
	public static String execute(int num, int ans) {
		
		if (num == ans) {
			return "正解です";
		}
		if (num > ans) {
			return "大きすぎます";
		}
		return "小さすぎます";
	}
}
