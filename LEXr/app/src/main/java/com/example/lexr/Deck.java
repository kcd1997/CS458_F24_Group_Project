package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class represents a collection of cards for a specific language.
 * It supports adding, removing, and shuffling cards, and allows setting the deck's
 * name, difficulty rating, and active status.
 * Has other feature for future updates: ie difficulty.
 */
public class Deck {

    // Fields representing the properties of the deck
    private String language;          // The language of the deck (e.g., Spanish, Latin)
    private List<com.example.lexr.Card> cards;         // The list of cards in the deck
    private String deckName;          // The name of the deck
    private int difficultyRating;     // The difficulty rating of the deck
    private boolean isActive;         // Indicates if the deck is active or inactive

    /**
     * Constructor for the Deck class.
     * Initializes the deck with a specified language, an empty card list,
     * a default deck name, a default difficulty rating, and sets the deck to active.
     *
     * Time complexity: O(1) - Constant time for initializing the fields.
     *
     * @param language The language of the deck (e.g., "Spanish", "Latin").
     */
    public Deck(String language) {
        this.language = language;          // Set the language of the deck O(1)
        this.cards = new ArrayList<>();    // Initialize an empty list for cards O(1)
        this.deckName = "Default";         // Default deck name O(1)
        this.difficultyRating = 1;         // Default difficulty rating O(1)
        this.isActive = true;              // Deck is active by default O(1)
    }

    /**
     * Adds a card to the deck.
     *
     * Time complexity: O(1) - Adding an element to the ArrayList is amortized constant time.
     *
     * @param card The card to be added to the deck.
     */
    public void addCard(com.example.lexr.Card card) {
        cards.add(card);  // Add the card to the list of cards in the deck O(1)
    }

    /**
     * Removes a card from the deck.
     *
     * Time complexity: O(n) - Removing an element from an ArrayList has linear time complexity
     * because it may require shifting elements.
     *
     * @param card The card to be removed from the deck.
     */
    public void removeCard(com.example.lexr.Card card) {
        cards.remove(card);  // Remove the card from the deck O(n), where n is the number of cards in the deck
    }

    /**
     * Shuffles the cards in the deck randomly.
     * This method is useful for reorganizing cards in a random order.
     *
     * Time complexity: O(n) - Shuffling an ArrayList takes linear time.
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);  // Shuffle the cards using the built-in shuffle method O(n)
    }

    // Getters

    /**
     * Gets the list of cards in the deck.
     *
     * Time complexity: O(1) - Returning the list reference is constant time.
     *
     * @return The list of cards in the deck.
     */
    public List<com.example.lexr.Card> getCards() {
        return cards;  // Return the list of cards O(1)
    }

    /**
     * Gets the language of the deck.
     *
     * Time complexity: O(1) - Accessing a field is constant time.
     *
     * @return The language of the deck.
     */
    public String getLanguage() {
        return language;  // Return the language of the deck O(1)
    }

    /**
     * Gets the name of the deck.
     * Time complexity: O(1) - Accessing a field is constant time.
     *
     * @return The deck's name.
     */
    public String getDeckName() {
        return deckName;  // Return the deck's name O(1)
    }

    /**
     * Gets the difficulty rating of the deck.
     * Time complexity: O(1) - Accessing a field is constant time.
     *
     * @return The difficulty rating of the deck.
     */
    public int getDifficultyRating() {
        return difficultyRating;  // Return the difficulty rating O(1)
    }

    /**
     * Checks if the deck is active.
     * Time complexity: O(1) - Accessing a field is constant time.
     *
     * @return True if the deck is active, false otherwise.
     */
    public boolean isActive() {
        return isActive;  // Return the active status O(1)
    }

    // Setters

    /**
     * Sets the list of cards in the deck.
     * Time complexity: O(1) - Assigning a reference to a list is constant time.
     *
     * @param cards The list of cards to set for the deck.
     */
    public void setCards(List<com.example.lexr.Card> cards) {
        this.cards = cards;  // Set the list of cards O(1)
    }

    /**
     * Sets the language of the deck.
     * Time complexity: O(1) - Assigning a string is constant time.
     *
     * @param language The language to set for the deck.
     */
    public void setLanguage(String language) {
        this.language = language;  // Set the language O(1)
    }

    /**
     * Sets the name of the deck.
     * Time complexity: O(1) - Assigning a string is constant time.
     *
     * @param deckName The name to set for the deck.
     */
    public void setDeckName(String deckName) {
        this.deckName = deckName;  // Set the deck's name O(1)
    }

    /**
     * Sets the difficulty rating for the deck.
     * Time complexity: O(1) - Assigning an integer is constant time.
     *
     * @param difficultyRating The difficulty rating to set.
     */
    public void setDifficultyRating(int difficultyRating) {
        this.difficultyRating = difficultyRating;  // Set the difficulty rating O(1)
    }

    /**
     * Sets whether the deck is active or inactive.
     * Time complexity: O(1) - Assigning a boolean is constant time.
     *
     * @param active True to set the deck as active, false to set it as inactive.
     */
    public void setActive(boolean active) {
        this.isActive = active;  // Set the active status O(1)
    }
}
