package hitblow.model.AI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hitblow.model.bean.ComBean;
import hitblow.model.manager.CoreManager;

public class Analyzer {
	/**
	 * 最も情報エントロピーの高い選択肢のリストを作成します。
	 * @param com - ComBean
	 * @return targetList - List
	 */
	public static List<Integer> execute(ComBean com){
		List<Integer> targetList = new ArrayList<Integer>();
		List<Integer> secPool = com.getSecPool();
		List<Integer> atkPool = com.getAtkPool();
		Map<Integer, Map<Integer, List<Integer>>> records = new HashMap<Integer, Map<Integer, List<Integer>>>();
		
		for(Integer atkNum : atkPool) {
			Map<Integer, List<Integer>> record = new HashMap<Integer, List<Integer>>();
			for(Integer targetNum : secPool) {
				int hitblow = CoreManager.countHitBlow(atkNum, targetNum);
				List<Integer> tmp;
				if(record.containsKey(hitblow)) {
					tmp = record.get(hitblow);
				} else {
					tmp = new ArrayList<Integer>();
				}
				tmp.add(targetNum);
				record.put(hitblow, tmp);
			}
			if(record.size() > 1) {
				records.put(atkNum, record);
			}
		}
		
		double maxEntropy = 0.;
		for(Integer targetNum : records.keySet()) {
			double entropy = Calculator.getEntropy(records.get(targetNum));
			if(entropy > maxEntropy) {
				targetList.clear();
				maxEntropy = entropy;
			}
			if(entropy == maxEntropy) {
				targetList.add(targetNum);
			}
		}
		
		return targetList;
	}
}
