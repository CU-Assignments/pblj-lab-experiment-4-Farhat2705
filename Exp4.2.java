Experiment 4.2: Card Collection System

Objective:
Develop a Java program that collects and stores playing cards to help users find all the cards of a given symbol (suit).
The program should utilize the Collection interface (such as ArrayList, HashSet, or HashMap) to manage the card data efficiently.

Understanding the Problem Statement

1. Card Structure:
Each card consists of a symbol (suit) and a value (rank).

Example card representations:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

2. Operations Required:
Add Cards → Store card details in a collection.
Find Cards by Symbol (Suit) → Retrieve all cards belonging to a specific suit (e.g., all "Hearts").
Display All Cards → Show all stored cards.

3. Collections Usage:
ArrayList: To store cards in an ordered manner.
HashSet: To prevent duplicate cards.
HashMap<String, List<Card>>: To organize cards based on suits for faster lookup.


Program/Code:

import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(rank, card.rank) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

class CardCollection {
    private HashSet<Card> cardSet;
    private HashMap<String, List<Card>> suitMap;

    public CardCollection() {
        cardSet = new HashSet<>();
        suitMap = new HashMap<>();
    }

    public void addCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        if (cardSet.contains(card)) {
            System.out.println("Error: Card \"" + card + "\" already exists.");
            return;
        }
        cardSet.add(card);
        suitMap.putIfAbsent(suit, new ArrayList<>());
        suitMap.get(suit).add(card);
        System.out.println("Card added: " + card);
    }

    public void findCardsBySuit(String suit) {
        if (!suitMap.containsKey(suit) || suitMap.get(suit).isEmpty()) {
            System.out.println("No cards found for " + suit + ".");
            return;
        }
        for (Card card : suitMap.get(suit)) {
            System.out.println(card);
        }
    }

    public void displayAllCards() {
        if (cardSet.isEmpty()) {
            System.out.println("No cards found.");
            return;
        }
        for (Card card : cardSet) {
            System.out.println(card);
        }
    }

    public void removeCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        if (!cardSet.contains(card)) {
            System.out.println("Error: Card \"" + card + "\" does not exist.");
            return;
        }
        cardSet.remove(card);
        suitMap.get(suit).remove(card);
        if (suitMap.get(suit).isEmpty()) {
            suitMap.remove(suit);
        }
        System.out.println("Card removed: " + card);
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();
        
        while (true) {
            System.out.println("\n1. Add Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Display All Cards");
            System.out.println("4. Remove Card");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter rank: ");
                    String rank = scanner.nextLine();
                    System.out.print("Enter suit: ");
                    String suit = scanner.nextLine();
                    collection.addCard(rank, suit);
                    break;
                case 2:
                    System.out.print("Enter suit to find: ");
                    suit = scanner.nextLine();
                    collection.findCardsBySuit(suit);
                    break;
                case 3:
                    collection.displayAllCards();
                    break;
                case 4:
                    System.out.print("Enter rank to remove: ");
                    rank = scanner.nextLine();
                    System.out.print("Enter suit to remove: ");
                    suit = scanner.nextLine();
                    collection.removeCard(rank, suit);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
