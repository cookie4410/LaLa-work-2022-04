package hitblow.model.AI;

import hitblow.model.bean.ComBean;
import hitblow.model.manager.PoolManager;

public class EasyAI extends AI {
	/**
	 * 完全にランダムな数値での攻撃を繰り返すアルゴリズム。
	 * @param com - ComBean
	 * @return target - int
	 */
	public int chooseTarget(ComBean com) {
		return PoolManager.getRandomNum(com.getAtkPool());
	}
}
