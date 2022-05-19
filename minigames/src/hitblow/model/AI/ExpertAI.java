package hitblow.model.AI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import hitblow.model.bean.ComBean;
import hitblow.model.bean.GameDataBean;
import hitblow.model.manager.CoreManager;
import hitblow.model.manager.PoolManager;

public class ExpertAI extends AI {
	public int execute(ComBean com, GameDataBean gData) {
		List<Integer> secPool = com.getSecPool();
		int target;
		if(secPool.size() == 1) {
			target = secPool.get(0);
		} else if(secPool.size() == 2) {
			target = secPool.get(new Random().nextInt(2));
		} else if(secPool.size() == 720) {
			giveHandicap(com, gData.getUserNum());
			target = PoolManager.getRandomNum(secPool);
		} else {
			target = chooseTarget(com);
		}
		return target;
	}
	
	/**
	 * 情報エントロピーが最も高くなる攻撃を選択するアルゴリズム。
	 * @param com - ComBean
	 * @return target - int
	 */
	public int chooseTarget(ComBean com) {
		List<Integer> targetList = Analyzer.execute(com);
		return PoolManager.getRandomNum(targetList);
	}
	
	public void giveHandicap(ComBean com, int _userNum) {
		List<Integer> userNum = CoreManager.num2list(_userNum);
		List<String> numList = new ArrayList<String>(
				Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
		List<Integer> secPool = com.getSecPool();
		List<Integer> atkPool = com.getAtkPool();
		for(Integer num : userNum) {
			numList.remove(String.valueOf(num));
		}
		String removeTarget = numList.get(new Random().nextInt(numList.size()));
		List<Integer> removeList = new ArrayList<Integer>();
		for(Integer num : secPool) {
			String strNum = String.valueOf(num);
			if(strNum.contains(removeTarget)) {
				removeList.add(num);
			}
		}
		for(Integer num : removeList) {
			secPool.remove(num);
			atkPool.remove(num);
		}
		com.setSecPool(secPool);
		com.setAtkPool(atkPool);
	}
}
