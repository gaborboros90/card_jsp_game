package workflow;

import java.util.ArrayList;
import java.util.Iterator;

import model.data.CardData;
import model.data.Player;

public class GameSimulator {
	private ArrayList<Player> players;
	private String cardName;
	private String selectedCategory;
	private String winner;
	private CardData computersCard;
	
	public GameSimulator(ArrayList<Player> players, String cardName, String selectedCategory) {
		this.players = players;
		this.cardName = cardName;
		this.selectedCategory = selectedCategory;
	}
	
	public void simulate() {
		ArrayList<CardData> playerDeck = players.get(0).getCardDeck();
		ArrayList<CardData> computerDeck = players.get(1).getCardDeck();
		int playerCardIndex = 0;
		int computerCardIndex = UtilFunctions.generateIntBetweenRange(0, computerDeck.size() - 1);
		int playerValue = 0;
		int computerValue = 0;
		
		for(int i = 0; i < playerDeck.size(); i++) {
			if(playerDeck.get(i).getName().equals(cardName)) {
				playerCardIndex = i;
				
				break;
			}
		}
		
		if(selectedCategory.equals("Speed")) {
			playerValue = playerDeck.get(playerCardIndex).getSpeed();
			computerValue = computerDeck.get(computerCardIndex).getSpeed();
		}
		else if(selectedCategory.equals("Attack")) {
			playerValue = playerDeck.get(playerCardIndex).getAttack();
			computerValue = computerDeck.get(computerCardIndex).getAttack();
		}
		else if(selectedCategory.equals("Deffence")) {
			playerValue = playerDeck.get(playerCardIndex).getDeffence();
			computerValue = computerDeck.get(computerCardIndex).getDeffence();
		}
		else if(selectedCategory.equals("Shooting")) {
			playerValue = playerDeck.get(playerCardIndex).getShooting();
			computerValue = computerDeck.get(computerCardIndex).getShooting();
		}
		
		if(playerValue > computerValue) {
			this.players.get(0).setScore(this.players.get(0).getScore() + 1);
			this.winner = this.players.get(0).getName();
		}
		else {
			this.players.get(1).setScore(this.players.get(1).getScore() + 1);
			this.winner = this.players.get(1).getName();
		}
		
		this.computersCard = players.get(1).getCardDeck().get(computerCardIndex);
		this.removeUsedCards(playerCardIndex, computerCardIndex);
	}
	
	public void removeUsedCards(int playerCardIdx, int computerCardIdx) {
		this.players.get(0).getCardDeck().remove(playerCardIdx);
		this.players.get(1).getCardDeck().remove(computerCardIdx);
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public boolean isGameEnded() {
		return this.players.get(0).getCardDeck().size() == 0;
	}

	public CardData getComputersCard() {
		return computersCard;
	}

	public String getWinner() {
		return winner;
	}
}
