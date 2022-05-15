package hitblow.model.manager;

import java.util.List;

import hitblow.model.bean.LogBean;

public class LogManager {
	public static void write(LogBean log, int _atkNum, int _hitblow) {
		String atkNum = String.valueOf(_atkNum);
		String hit = String.valueOf(_hitblow / 10) + " Hit";
		String blow = String.valueOf(_hitblow % 10) + " Blow";
		List<String> numLog = log.getNumLog();
		List<String> hitLog = log.getHitLog();
		List<String> blowLog = log.getBlowLog();
		numLog.add(0, atkNum);
		hitLog.add(0, hit);
		blowLog.add(0, blow);
		log.setNumLog(numLog);
		log.setHitLog(hitLog);
		log.setBlowLog(blowLog);
	}
}
