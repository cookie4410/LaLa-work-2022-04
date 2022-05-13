package hitblow.model.manager;

import java.util.List;

import hitblow.model.bean.LogBean;

public class LogManager {
	public static void write(LogBean log, int _atkNum, int _hitblow, String attacker) {
		String atkNum = String.valueOf(_atkNum);
		String hit = String.valueOf(_hitblow / 10);
		String blow = String.valueOf(_hitblow % 10);
		String hitblow = hit + "hit " + blow + "blow";
		String logText = attacker + ": " + atkNum + " -> " + hitblow;
		List<String> logList = log.getLogList();
		logList.add(logText);
		log.setLogList(logList);
	}
}
