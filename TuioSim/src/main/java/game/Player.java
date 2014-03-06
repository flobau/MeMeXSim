package game;

public class Player {
	private String card1;
	private String card2;
	private int score;
	
	public Player(){
		this.card1 = "";
		this.card2 = "";
		this.score = 0;
	}

	public String getCard1() {
		return card1;
	}

	public void setCard1(String card1) {
		this.card1 = card1;
	}

	public String getCard2() {
		return card2;
	}

	public void setCard2(String card2) {
		this.card2 = card2;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
