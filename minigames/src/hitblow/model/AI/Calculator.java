package hitblow.model.AI;

import java.util.List;
import java.util.Map;

public class Calculator {
	/**
	 * 情報エントロピーを計算します。
	 * @param record - Map
	 * @return entropy - double
	 */
	public static double getEntropy(Map<Integer, List<Integer>> record) {
		double entropy = 0.;
		double sum = 0.;
		for (List<Integer> list : record.values()) {
			sum += list.size();
		}
		for(List<Integer> list : record.values()) {
			double p = list.size() / sum;
			entropy += p * -(Math.log(p) / Math.log(2));
		}
		return entropy;
	}
}
