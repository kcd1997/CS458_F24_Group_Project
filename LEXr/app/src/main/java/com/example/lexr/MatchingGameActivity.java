package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * MatchingGameActivity handles a simple matching game where the user matches Spanish words
 * to their correct English translations. It keeps track of the user's correct and incorrect answers
 * and the time taken to complete the game.
 */
public class MatchingGameActivity extends AppCompatActivity {

    // UI elements for displaying Spanish words and English translation choices
    private TextView spanishWordTextView;
    private Button englishWordButton1, englishWordButton2, englishWordButton3;

    // Lists containing the sentences in Spanish, the correct English translations, and multiple-choice options
    private List<List<String>> allSpanishSentences;
    private List<List<String>> allCorrectEnglishWords;
    private List<List<List<String>>> allEnglishChoices;

    // Game state variables
    private int currentSentenceIndex = 0; // Tracks which sentence is currently being processed
    private int currentWordIndex = 0;     // Tracks which word in the sentence is currently being matched
    private int correctAnswers = 0;       // Tracks the number of correct answers
    private int incorrectAnswers = 0;     // Tracks the number of incorrect answers
    private List<String> incorrectWords;  // Stores the list of words answered incorrectly

    // Variables for timing the game
    private long startTime;  // Game start time
    private long endTime;    // Game end time

    /**
     * onCreate is called when the activity is first created. It initializes the UI components,
     * sets up the Spanish sentences and their corresponding translations, and starts the game timer.
     * Time complexity: O(1) - Initializing the UI elements and starting the timer is constant time.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the saved state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);

        // Start the timer when the activity is created
        startTime = SystemClock.elapsedRealtime(); // O(1)

        // Initialize UI components
        spanishWordTextView = findViewById(R.id.spanishWordTextView); // O(1)
        englishWordButton1 = findViewById(R.id.englishWordButton1);   // O(1)
        englishWordButton2 = findViewById(R.id.englishWordButton2);   // O(1)
        englishWordButton3 = findViewById(R.id.englishWordButton3);   // O(1)

        // Make sure all UI components are visible
        spanishWordTextView.setVisibility(View.VISIBLE); // O(1)
        englishWordButton1.setVisibility(View.VISIBLE);  // O(1)
        englishWordButton2.setVisibility(View.VISIBLE);  // O(1)
        englishWordButton3.setVisibility(View.VISIBLE);  // O(1)

        // Initialize Spanish sentences from decks 1, 2, or 3
        allSpanishSentences = Arrays.asList(
                Arrays.asList("Yo", "hablo", "español."),
                Arrays.asList("Ellos", "comen", "pan."),
                Arrays.asList("Nosotros", "vivimos", "aquí.")
        ); // O(1)

        // Correct English translations corresponding to each word in the Spanish sentences
        allCorrectEnglishWords = Arrays.asList(
                Arrays.asList("I", "speak", "Spanish"),
                Arrays.asList("They", "eat", "bread"),
                Arrays.asList("We", "live", "here")
        ); // O(1)

        // Choices for English translations for each word in the sentences
        allEnglishChoices = Arrays.asList(
                Arrays.asList(
                        Arrays.asList("I", "You", "He"),
                        Arrays.asList("speak", "eat", "run"),
                        Arrays.asList("Spanish", "French", "English")
                ),
                Arrays.asList(
                        Arrays.asList("They", "Us", "We"),
                        Arrays.asList("eat", "drink", "sleep"),
                        Arrays.asList("bread", "milk", "water")
                ),
                Arrays.asList(
                        Arrays.asList("We", "You", "They"),
                        Arrays.asList("live", "eat", "drink"),
                        Arrays.asList("here", "there", "everywhere")
                )
        ); // O(1)

        // Initialize the list to track incorrect words
        incorrectWords = new ArrayList<>(); // O(1)

        // Load the first Spanish word in the current sentence
        loadSpanishWord(); // O(n), where n is the number of choices to shuffle

        // Set up button click listeners to check if the user's answers are correct
        setUpButtonClickListeners(); // O(1)
    }

    /**
     * Loads the current Spanish word from the sentence and sets the corresponding English word choices
     * as buttons. If all sentences have been processed, it shows a summary of the game.
     * Time complexity: O(n) - Where n is the number of choices to shuffle.
     */
    private void loadSpanishWord() {
        if (currentSentenceIndex >= allSpanishSentences.size()) { // O(1)
            // End the game when all sentences are completed
            endTime = SystemClock.elapsedRealtime(); // O(1)
            showSummary(); // O(1)
            return;
        }

        // Display the current Spanish word
        List<String> currentSentence = allSpanishSentences.get(currentSentenceIndex); // O(1)
        spanishWordTextView.setText(currentSentence.get(currentWordIndex)); // O(1)

        // Get the English word choices for the current word and shuffle them
        List<String> choices = new ArrayList<>(allEnglishChoices.get(currentSentenceIndex).get(currentWordIndex)); // O(1)
        Collections.shuffle(choices); // O(n), where n is the number of choices

        // Set the shuffled choices to the buttons
        englishWordButton1.setText(choices.get(0)); // O(1)
        englishWordButton2.setText(choices.get(1)); // O(1)
        englishWordButton3.setText(choices.get(2)); // O(1)
    }

    /**
     * Sets up click listeners for each button to check if the selected English word is correct.
     * Time complexity: O(1) - Setting up listeners is constant time.
     */
    private void setUpButtonClickListeners() {
        englishWordButton1.setOnClickListener(this::checkAnswer); // O(1)
        englishWordButton2.setOnClickListener(this::checkAnswer); // O(1)
        englishWordButton3.setOnClickListener(this::checkAnswer); // O(1)
    }

    /**
     * Checks if the selected English word matches the correct translation. If correct,
     * it increments the correct answers; otherwise, it records the incorrect word.
     * After each answer, it moves to the next word or sentence.
     * Time complexity: O(1) - Checking the answer and updating the state are constant time operations.
     *
     * @param view The button clicked by the user.
     */
    private void checkAnswer(View view) {
        Button clickedButton = (Button) view; // O(1)
        String selectedEnglishWord = clickedButton.getText().toString(); // O(1)

        // Check if the selected word matches the correct word
        if (selectedEnglishWord.equals(allCorrectEnglishWords.get(currentSentenceIndex).get(currentWordIndex))) { // O(1)
            correctAnswers++; // O(1)
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show(); // O(1)
        } else {
            incorrectAnswers++; // O(1)
            incorrectWords.add(allSpanishSentences.get(currentSentenceIndex).get(currentWordIndex)); // O(1)
            Toast.makeText(this, "Incorrect! Try again.", Toast.LENGTH_SHORT).show(); // O(1)
        }

        currentWordIndex++; // O(1)
        if (currentWordIndex < allSpanishSentences.get(currentSentenceIndex).size()) { // O(1)
            loadSpanishWord(); // O(n), where n is the number of choices
        } else {
            // Move to the next sentence after completing the current one
            currentWordIndex = 0; // O(1)
            currentSentenceIndex++; // O(1)
            loadSpanishWord(); // O(n)
        }
    }

    /**
     * Shows a summary of the game including the total correct and incorrect answers,
     * the time taken to complete the game, and a list of incorrectly translated words.
     * Time complexity: O(k), where k is the number of incorrect words to display.
     */
    private void showSummary() {
        // Calculate the total time taken for the game
        long totalTimeTaken = endTime - startTime; // O(1)
        long secondsTaken = totalTimeTaken / 1000; // O(1)

        // Build the summary text
        StringBuilder summary = new StringBuilder(); // O(1)
        summary.append("Game Completed!\n"); // O(1)
        summary.append("Correct Answers: ").append(correctAnswers).append("\n"); // O(1)
        summary.append("Incorrect Answers: ").append(incorrectAnswers).append("\n"); // O(1)
        summary.append("Total Time Taken: ").append(secondsTaken).append(" seconds\n"); // O(1)

        // Add incorrect words to the summary if there are any
        if (!incorrectWords.isEmpty()) { // O(1)
            summary.append("Incorrect Words: ").append(incorrectWords).append("\n"); // O(k), where k is the number of incorrect words
        }

        // Display the summary in a dialog.
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this); // O(1)
        builder.setTitle("Game Summary"); // O(1)

        // Use a TextView to display the summary in the dialog
        TextView summaryTextView = new TextView(this); // O(1)
        summaryTextView.setText(summary.toString()); // O(k)
        summaryTextView.setTextSize(20); // O(1)
        summaryTextView.setPadding(50, 50, 50, 50); // O(1)
        summaryTextView.setGravity(View.TEXT_ALIGNMENT_CENTER); // O(1)

        builder.setView(summaryTextView); // O(1)
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss()); // O(1)
        builder.show(); // O(1)
    }
}
