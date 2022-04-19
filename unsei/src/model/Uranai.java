package model;

public class Uranai {
	public String getFortune() {
		String[] uranai = {"大吉", "中吉", "小吉", "末吉", "凶"};
		int index = (int) (Math.random() * 5); // 0 ... 4
		String word = uranai[index];		
		return word;
	}

}
