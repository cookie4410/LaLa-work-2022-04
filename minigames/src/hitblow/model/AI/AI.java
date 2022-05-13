package hitblow.model.AI;

import java.util.List;
import java.util.Random;

import hitblow.model.bean.ComBean;
import hitblow.model.bean.GameDataBean;
import hitblow.model.manager.PoolManager;

public abstract class AI {
	/**
	 * 難易度に応じて最適な数値を選択します。
	 * @param com - ComBean
	 * @return int - targetNum
	 */
	public static int execute(ComBean com, GameDataBean gData) {
		List<Integer> secPool = com.getSecPool();
		int target;
		if(secPool.size() == 1) {
			target = secPool.get(0);
		} else if(secPool.size() == 2) {
			target = secPool.get(new Random().nextInt(2));
		} else if(secPool.size() == 720) {
			target = PoolManager.getRandomNum(secPool);
		} else {
			target = chooseTarget(com);
		}
		return target;
	}
	
	public static int chooseTarget(ComBean com) {
		return 0;
	}
}
