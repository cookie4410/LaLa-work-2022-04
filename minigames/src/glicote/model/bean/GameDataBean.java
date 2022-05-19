package glicote.model.bean;

public class GameDataBean {
	private int userStep;
	private int comStep;
	private String winner;
	private String winnerHand;
	
	public GameDataBean() {
		this.userStep = 0;
		this.comStep = 0;
	}
	
	public int getUserStep() {
		return userStep;
	}
	public void setUserStep(int userStep) {
		this.userStep = userStep;
	}
	public int getComStep() {
		return comStep;
	}
	public void setComStep(int comStep) {
		this.comStep = comStep;
	}
	public String getWinnerHand() {
		return winnerHand;
	}
	public void setWinnerHand(String winnerHand) {
		this.winnerHand = winnerHand;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}
