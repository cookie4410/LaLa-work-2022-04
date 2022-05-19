package hitblow.model.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CoreManager {
	/**
	 * Hit-Blowの値を返します。
	 * @param _atkNum - int
	 * @param _targetNum - int
	 * @return hitblow - int
	 */
	public static int countHitBlow(int _atkNum, int _targetNum) {
		List<Integer> atkNum = num2list(_atkNum);
		List<Integer> targetNum = num2list(_targetNum);
		int hitblow = 0;
		for(int i = 0; i < 3; i++) {
			if(atkNum.get(i) == targetNum.get(i)) {
				hitblow += 10;
			} else if(targetNum.contains(atkNum.get(i))) {
				hitblow++;
			}
		}
		return hitblow;
	}
	
	public static int countHitBlow(List<Integer> atkNum, int _targetNum) {
		List<Integer> targetNum = num2list(_targetNum);
		int hitblow = 0;
		for(int i = 0; i < 3; i++) {
			if(atkNum.get(i) == targetNum.get(i)) {
				hitblow += 10;
			} else if(targetNum.contains(atkNum.get(i))) {
				hitblow++;
			}
		}
		return hitblow;
	}
	
	/**
	 * 数値をList型に変換します。
	 * @param num - int
	 * @return arrNum - List
	 */
	public static List<Integer> num2list(int num){
		List<Integer> arrNum = new ArrayList<>();
		arrNum.add(num / 100);
		arrNum.add((num % 100) / 10);
		arrNum.add(num % 10);
		return arrNum;
	}

	public static String calcDuration(long startAt, long endAt) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		Calendar result = Calendar.getInstance();
		start.setTimeInMillis(startAt);
		end.setTimeInMillis(endAt);
		long diff = end.getTimeInMillis() - start.getTimeInMillis() - result.getTimeZone().getRawOffset();
		result.setTimeInMillis(diff);
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		return sdf.format(result.getTime());
	}
}
