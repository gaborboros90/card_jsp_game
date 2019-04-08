package model.data;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<CardData> cardDeck;
	private int score = 0;
	
	public Player(String name, ArrayList<CardData> cardDeck, int score) {
		super();
		this.name = name;
		this.cardDeck = cardDeck;
		this.score = score;
	}
	
	public Player(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CardData> getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(ArrayList<CardData> cardDeck) {
		this.cardDeck = cardDeck;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", cardDeck=" + cardDeck + ", score="
				+ score + "]";
	}
}
