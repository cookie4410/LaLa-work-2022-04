package hitblow.model.AI;

import java.util.List;

import hitblow.model.bean.ComBean;
import hitblow.model.manager.PoolManager;

public class HardAI extends AI {
	/**
	 * 情報エントロピーが最も高くなる攻撃を選択するアルゴリズム。
	 * @param com - ComBean
	 * @return target - int
	 */
	public static int chooseTarget(ComBean com) {
		List<Integer> targetList = Analyzer.execute(com);
		return PoolManager.getRandomNum(targetList);
	}
}
