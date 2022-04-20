package model;

public class Hantei {
	public static String exec(int user, int com) {
		String result = "";	
		if (user == com) {
			result = "draw";
		} else if ((user + 1) % 3 == com) {
			result = "user";
		} else {
			result = "com";
		}
		return result;
	}
}
