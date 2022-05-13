package model;

import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable{
	private int target;
	private int result;
	private int count;
	private ArrayList<String> log;

	public GameData(){}
	
	public GameData(int target) {
		this.target = target;
		this.count = 0;
	}

	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<String> getLog() {
		return log;
	}
	public void setLog(ArrayList<String> log) {
		this.log = log;
	}
}
