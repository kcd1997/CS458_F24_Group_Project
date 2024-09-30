package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import java.util.List;

/**
 * The Card class represents a vocabulary card with a word, its conjugates, translation,
 * and additional properties such as difficulty level, favorite status, and flipped state.
 * Has additional setters for future modifications to program.
 */
public class Card {
    // Fields representing the attributes of a card
    private String word;              // The main word on the card
    private List<String> conjugates;  // List of conjugated forms of the word
    private String translation;       // The English translation of the word
    private boolean isFlipped;        // State indicating if the card is flipped
    private int difficultyLevel;      // Difficulty level of the card, default is 1
    private boolean isFavorite;       // Boolean to indicate if the card is marked as a favorite

    /**
     * Constructor to initialize the card with word, conjugates, and translation.
     * The card starts unf-lipped, with default difficulty level 1 and not marked as favorite.
     * Time complexity: O(1) - Initializing a constant number of fields is constant time.
     *
     * @param word         The word displayed on the card.
     * @param conjugates   The list of conjugated forms of the word.
     * @param translation  The translation of the word in English.
     */
    public Card(String word, List<String> conjugates, String translation) {
        this.word = word;  // Initialize the main word of the card
        this.conjugates = conjugates;  // Initialize conjugated forms of the word
        this.translation = translation;  // Set the translation
        this.isFlipped = false;  // Initially, the card is not flipped
        this.difficultyLevel = 1;  // Default difficulty level is set to 1
        this.isFavorite = false;   // The card is not a favorite by default
    }

    /**
     * Flips the card by toggling the flipped state.
     * If the card is not flipped, flipping will show the other side and vice versa.
     * Time complexity: O(1) - Toggling a boolean is a constant time operation.
     */
    public void flipCard() {
        isFlipped = !isFlipped;  // Toggle the flipped state of the card
    }

    // Getters

    /**
     * Returns the main word of the card.
     * Time complexity: O(1) - Accessing a field is a constant time operation.
     *
     * @return the word of the card.
     */
    public String getWord() {
        return word;  // Return the word on the card
    }

    /**
     * Returns the list of conjugated forms of the word.
     * Time complexity: O(1) - Returning a reference to a list is constant time.
     *
     * @return the list of conjugates.
     */
    public List<String> getConjugates() {
        return conjugates;  // Return the list of conjugates for the word
    }

    /**
     * Returns the translation of the word in English.
     * Time complexity: O(1) - Accessing a field is constant time.
     *
     * @return the translation of the word.
     */
    public String getTranslation() {
        return translation;  // Return the translation of the word
    }

    /**
     * Returns whether the card is flipped or not.
     * Time complexity: O(1) - Accessing a boolean field is constant time.
     *
     * @return true if the card is flipped, false otherwise.
     */
    public boolean isFlipped() {
        return isFlipped;  // Return the flipped state of the card
    }

    /**
     * Returns the difficulty level of the card.
     * Time complexity: O(1) - Accessing an integer field is constant time.
     *
     * @return the difficulty level of the card.
     */
    public int getDifficultyLevel() {
        return difficultyLevel;  // Return the difficulty level of the card
    }

    /**
     * Returns whether the card is marked as a favorite.
     * Time complexity: O(1) - Accessing a boolean field is constant time.
     *
     * @return true if the card is marked as a favorite, false otherwise.
     */
    public boolean isFavorite() {
        return isFavorite;  // Return the favorite status of the card
    }

    // Setters

    /**
     * Sets the word of the card.
     * Time complexity: O(1) - Setting a string reference is constant time.
     *
     * @param word the new word to be set on the card.
     */
    public void setWord(String word) {
        this.word = word;  // Set a new word on the card
    }

    /**
     * Sets the list of conjugates for the card.
     * Time complexity: O(1) - Assigning a reference to a list is constant time.
     *
     * @param conjugates the new list of conjugates.
     */
    public void setConjugates(List<String> conjugates) {
        this.conjugates = conjugates;  // Set new conjugated forms for the word
    }

    /**
     * Sets the translation of the word.
     * Time complexity: O(1) - Setting a string reference is constant time.
     *
     * @param translation the new translation of the word.
     */
    public void setTranslation(String translation) {
        this.translation = translation;  // Set a new translation for the word
    }

    /**
     * Sets the flipped state of the card.
     * Time complexity: O(1) - Setting a boolean value is constant time.
     *
     * @param flipped the new flipped state of the card.
     */
    public void setFlipped(boolean flipped) {
        isFlipped = flipped;  // Set whether the card is flipped or not
    }

    /**
     * Sets the difficulty level of the card.
     * Time complexity: O(1) - Setting an integer field is constant time.
     *
     * @param difficultyLevel the new difficulty level to be set.
     */
    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;  // Set a new difficulty level for the card
    }

    /**
     * Marks the card as a favorite or removes it from favorites.
     * Time complexity: O(1) - Setting a boolean value is constant time.
     *
     * @param favorite the new favorite status to be set.
     */
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;  // Set whether the card is marked as a favorite
    }
}
