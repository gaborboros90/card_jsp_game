package workflow;

import java.util.ArrayList;

import javax.smartcardio.Card;

import model.data.CardData;

public class CardFactory {
	public static ArrayList<CardData> createCards() {
		ArrayList<CardData> cardDeck = new ArrayList<CardData>();
		
		cardDeck.add(new CardData("Lionel Messi",92,94,78,95,"messi.png"));
		cardDeck.add(new CardData("Marco Reus",85,84,72,87,"marco-reus.png"));
		cardDeck.add(new CardData("Robin van Persie",89,90,70,86,"van-persie.png"));
		cardDeck.add(new CardData("Andres Iniesta",84,88,84,96,"iniesta.png"));
		cardDeck.add(new CardData("Thomas Muller",90,90,89,87,"muller.png"));
		cardDeck.add(new CardData("Cristiano Ronaldo",94,95,70,96,"ronaldo.png"));
		cardDeck.add(new CardData("Steven Gerrard",92,90,84,90,"gerrard.png"));
		cardDeck.add(new CardData("Neymar",94,94,80,90,"neymar.png"));
		cardDeck.add(new CardData("Pepe",84,84,96,84,"pepe.png"));
		cardDeck.add(new CardData("Gerrard Pique",94,95,70,96,"pique.png"));
		cardDeck.add(new CardData("Sergio Ramos",94,95,70,96,"ramos.png"));
		cardDeck.add(new CardData("Frank Ribery",88,90,77,90,"ribery.png"));
		cardDeck.add(new CardData("Carlos Tevez",90,84,84,93,"tevez.png"));
		cardDeck.add(new CardData("Toni Kroos",76,69,78,85,"toni-kroos.png"));
		cardDeck.add(new CardData("Bonucci",89,80,90,78,"bonucci.png"));
		cardDeck.add(new CardData("Alex Vidal",89,67,90,90,"vidal.png"));
		cardDeck.add(new CardData("Viktor Valdes",70,70,70,70,"valdes.png"));
		cardDeck.add(new CardData("Wayne Rooney",94,96,89,90,"wayne-rooney.png"));
		cardDeck.add(new CardData("Zlatan Ibrahimovic",91,90,89,96,"ibra.png"));
		cardDeck.add(new CardData("Philip Lahm",92,90,77,88,"lah.png"));
		
		return cardDeck;
	}
}
