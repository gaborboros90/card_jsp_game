package model.data;

public class ResponeObject {
	private CardData computerCard;
	private int computerScore;
	private int playerScore;
	private String winnerName;
	private boolean isGameEnded = false;
	
	public ResponeObject(){}
	
	public ResponeObject(CardData computerCard, int computerScore,
			int playerScore, String winnerName, boolean isGameEnded) {
		super();
		this.computerCard = computerCard;
		this.computerScore = computerScore;
		this.playerScore = playerScore;
		this.winnerName = winnerName;
		this.isGameEnded = isGameEnded;
	}
	
	public CardData getComputerCard() {
		return computerCard;
	}
	public void setComputerCard(CardData computerCard) {
		this.computerCard = computerCard;
	}
	public int getComputerScore() {
		return computerScore;
	}
	public void setComputerScore(int computerScore) {
		this.computerScore = computerScore;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	public String getWinnerName() {
		return winnerName;
	}
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

	public boolean isGameEnded() {
		return isGameEnded;
	}

	public void setGameEnded(boolean isGameEnded) {
		this.isGameEnded = isGameEnded;
	}
}
