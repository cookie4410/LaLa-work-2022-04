package model;

public class Hantei {
	public static void exec(PlayResult result) {
		if (result.getUser() == result.getCom()) {
			result.setWinner("draw");
		} else if ((result.getUser() + 1) % 3 == result.getCom()) {
			result.setWinner("user");
		} else {
			result.setWinner("com");
		}
	}
}
