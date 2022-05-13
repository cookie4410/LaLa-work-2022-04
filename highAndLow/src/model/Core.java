package model;

import java.util.ArrayList;

public class Core {
	public static void judge (GameData gd, int num) {
		int target = gd.getTarget();
		if(target == num) {
			gd.setResult(10);
		}else if(target < num){
			gd.setResult(-1);
		}else {
			gd.setResult(1);
		}
	}
	
	public static void stepCount(GameData gd) {
		gd.setCount(gd.getCount() + 1);
	}
	
	public static boolean checkNum(int num) {
		if(0 < num && num < 100) {return true;}
		else {return false;}
	}
	
	public static void addLog(GameData gd, int num) {
		int result = gd.getResult();
		ArrayList<String> logList = gd.getLog();
		if(logList == null) {
			logList = new ArrayList<String>();
		}
		String log = "";
		if(result == 1) {
			log = num + ": もっと大きい"; 
		} else {
			log = num + ": もっと小さい";
		}
		logList.add(log);
		gd.setLog(logList);
	}
}
