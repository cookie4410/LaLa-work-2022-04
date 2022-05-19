package hitblow.model.bean;

import java.io.Serializable;

public class GameDataBean implements Serializable {
	private int userNum;
	private int comNum;
	private long startAt;
	
	public GameDataBean(){}
	public GameDataBean(int userNum){
		this.userNum = userNum;
		this.startAt = System.currentTimeMillis();
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getComNum() {
		return comNum;
	}

	public void setComNum(int comNum) {
		this.comNum = comNum;
	}
	public long getStartAt() {
		return startAt;
	}
	public void setStartAt(long startAt) {
		this.startAt = startAt;
	}
}
