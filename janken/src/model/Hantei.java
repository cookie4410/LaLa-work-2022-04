package model;

public class Hantei {
	public static void exec(Player player) {
		if (player.getUser() == player.getCom()) {
			player.setWinner("draw");
		} else if ((player.getUser() + 1) % 3 == player.getCom()) {
			player.setWinner("user");
		} else {
			player.setWinner("com");
		}
	}
}
