package hitblow.model.bean;

import java.io.Serializable;

public class GameDataBean implements Serializable {
	private int userNum;
	private int comNum;
	
	public GameDataBean(){}
	public GameDataBean(int userNum){
		this.userNum = userNum;
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
}
