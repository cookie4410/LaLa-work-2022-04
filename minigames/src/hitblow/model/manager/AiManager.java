package hitblow.model.manager;

import hitblow.model.bean.ComBean;
import hitblow.model.bean.GameDataBean;
import hitblow.util.Level;

public class AiManager {
	/**
	 * 難易度ごとの処理系へ分岐します。
	 * @param com - ComBean
	 * @return target - int
	 */
	public static int executeAI(ComBean com, GameDataBean gData) {
		return Level.valueOf(com.getLevel()).runAI(com, gData);
	}
}
