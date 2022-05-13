package hitblow.model.AI;

import hitblow.model.bean.ComBean;
import hitblow.model.manager.PoolManager;

public class NormalAI extends AI {
	/**
	 * これまでの結果から、正解になりえない数値を除外した上で、
	 * ランダムな攻撃を繰り返すアルゴリズム。
	 * @param com - ComBean
	 * @return target - int
	 */
	public static int chooseTarget(ComBean com) {
		return PoolManager.getRandomNum(com.getSecPool());
	}
}
