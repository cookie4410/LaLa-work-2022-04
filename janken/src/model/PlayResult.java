package model;

import java.io.Serializable;

public class PlayResult
implements Serializable {
	private int user;
	private int com;
	private String winner;
	
	public PlayResult () {}
	
	public PlayResult(int user, int com) {
		this.user = user;
		this.com = com;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	

}
