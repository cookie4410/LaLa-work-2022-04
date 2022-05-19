package glicote.model.manager;

public class CoreManager {
	public static String judge(int userHand, int comHand) {
		int result = (userHand - comHand + 3) % 3;
		switch(result) {
			case 0:
				return "draw";
			case 1:
				return "user";
			case 2:
				return "com";
		}
		return null;
	}
}
