package glicote.util;

public enum Hands {
	PAPER(
			0,
			"パイナップル",
			"<i id=\"PAPER\" class=\"lar la-hand-paper la-10x\"></i>"
			),
	SCISSORS(
			1,
			"チョコレート",
			"<i id=\"SCISSORS\" class=\"lar la-hand-peace la-10x\"></i>"
			),
	ROCK(
			2,
			"グリコ",
			"<i id=\"ROCK\" class=\"lar la-hand-rock la-10x\"></i>"
			);
	
	private int id;
	private String text;
	private String tag;
	
	private Hands(int id, String text, String tag) {
		this.id = id;
		this.text = text;
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getTag() {
		return tag;
	}
}
