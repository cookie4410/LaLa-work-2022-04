package model;

public class Hantei {
	public static void exec(PlayInfo pinfo) {
		int user = pinfo.getUser();
		int com = pinfo.getCom();
		String result = "";
		if (user == com) {
			result = "draw";
		} else if ((user + 1) % 3 == com) {
			result = "user";
		} else {
			result = "com";
		}
		pinfo.setWinner(result);
	}
}
