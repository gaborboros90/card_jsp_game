package workflow;

import java.util.ArrayList;

import model.data.CardData;
import model.data.Player;

public class PlayerFactory {
	public static ArrayList<Player> createPlayers(String username) {
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<CardData> allCards = CardFactory.createCards();
		ArrayList<CardData> playersCardDeck = new ArrayList<CardData>();
		ArrayList<CardData> computersCardDeck = new ArrayList<CardData>();
		
		for(CardData card:allCards) {
			if(UtilFunctions.generateIntBetweenRange(0, 1) == 0) {
				if(playersCardDeck.size() < allCards.size() / 2) {
					playersCardDeck.add(card);
				}
				else {
					computersCardDeck.add(card);
				}
			}
			else {
				if(computersCardDeck.size() < allCards.size() / 2) {
					computersCardDeck.add(card);
				}
				else {
					playersCardDeck.add(card);
				}
			}
		}
		
		Player user = new Player(username, playersCardDeck, 0);
		Player computer = new Player("Computer", computersCardDeck, 0);
		
		players.add(user);
		players.add(computer);
		
		return players;
	}
}
