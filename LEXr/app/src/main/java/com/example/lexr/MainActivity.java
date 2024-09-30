package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

/**
 * MainActivity is the main entry point of the app, which allows users to select different decks or
 * play games like Matching Game and Sentence Matching.
 * It handles the user's interaction with buttons to navigate to various activities in the app.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // Tag used for logging lifecycle events
    private static final String SELECTED_DECK_KEY = "selectedDeck";
    private String selectedDeck;  // Keep track of the selected deck

    /**
     * Called when the activity is first created. This method sets up the initial UI components and
     * assigns click listeners to the buttons for deck selection and game modes.
     * Time complexity: O(1) - Setting up buttons and click listeners is a constant-time operation.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the saved state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_selection); // O(1)

        // Log the lifecycle event
        Log.d(TAG, "onCreate called");

        // Restore the selected deck if saved
        if (savedInstanceState != null) {
            selectedDeck = savedInstanceState.getString(SELECTED_DECK_KEY);
            Log.d(TAG, "Restored selected deck: " + selectedDeck);
        }

        // Button references for deck selection buttons
        Button spanishDeck1 = findViewById(R.id.spanishDeck1);  // O(1)
        Button spanishDeck2 = findViewById(R.id.spanishDeck2);  // O(1)
        Button spanishDeck3 = findViewById(R.id.spanishDeck3);  // O(1)
        Button spanishDeck4 = findViewById(R.id.spanishDeck4);  // O(1)
        Button latinDeck = findViewById(R.id.latinDeck);        // O(1)
        Button sentencesDeck = findViewById(R.id.sentencesDeck); // O(1)
        Button matchingGameButton = findViewById(R.id.matchingGameButton); // O(1)

        // Set click listeners for each deck selection button
        spanishDeck1.setOnClickListener(v -> openDeck("SpanishDeck1"));  // O(1)
        spanishDeck2.setOnClickListener(v -> openDeck("SpanishDeck2"));  // O(1)
        spanishDeck3.setOnClickListener(v -> openDeck("SpanishDeck3"));  // O(1)
        spanishDeck4.setOnClickListener(v -> openDeck("SpanishDeck4"));  // O(1)
        latinDeck.setOnClickListener(v -> openDeck("LatinDeck"));        // O(1)

        // Set click listener for "Slide Sentences" button
        sentencesDeck.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SentenceSlidingActivity.class);
            intent.putExtra("deckName", "Sentences"); // O(1)
            startActivity(intent);  // O(1)
        });

        // Set click listener for "Matching Game" button
        matchingGameButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MatchingGameActivity.class);
            startActivity(intent);  // O(1)
        });

        // Button to view favorite cards
        Button viewFavoritesButton = findViewById(R.id.viewFavoritesButton); // O(1)
        viewFavoritesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoriteCardsActivity.class);
            startActivity(intent);  // O(1)
        });
    }

    /**
     * Called when the activity becomes visible to the user.
     * This method logs the lifecycle event and can contain logic to start animations or refresh UI.
     * Time complexity: O(1) - Logging is constant time.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    /**
     * Called when the activity starts interacting with the user.
     * Typically used to resume ongoing tasks or UI updates.
     * Time complexity: O(1) - Logging is constant time.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    /**
     * Called when the activity is partially obscured or about to stop interacting with the user.
     * This is where tasks can be paused, or data can be saved temporarily.
     * Time complexity: O(1) - Logging is constant time.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    /**
     * Called when the activity is no longer visible to the user.
     * Any resources not needed while in the background should be released here.
     * Time complexity: O(1) - Logging is constant time.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    /**
     * Called after the activity has been stopped and is restarting again.
     * This can be used to re-initialize components or refresh data.
     * Time complexity: O(1) - Logging is constant time.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
    }

    /**
     * Called before the activity is destroyed.
     * This is where cleanup operations like closing connections or freeing resources should happen.
     * Time complexity: O(1) - Logging is constant time.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    /**
     * Opens the selected deck and navigates to CardDisplayActivity.
     * The selected deck's name is passed to the next activity via Intent extras.
     * Time complexity: O(1) - Creating an Intent and starting an activity is constant time.
     *
     * @param deckName The name of the deck to be opened.
     */
    private void openDeck(String deckName) {
        Intent intent = new Intent(this, CardDisplayActivity.class);  // O(1)
        intent.putExtra("deckName", deckName); // O(1)
        startActivity(intent);  // O(1)
    }

    // Save the selected deck to handle configuration changes
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (selectedDeck != null) {
            outState.putString(SELECTED_DECK_KEY, selectedDeck);
        }
    }
}
