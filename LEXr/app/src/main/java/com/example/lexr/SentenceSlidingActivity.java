package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SentenceMatchingActivity handles a sentence matching game where users match Spanish words
 * to complete English sentences. The user can go through multiple sentences, and the game
 * progresses with the "Next Sentence" button.
 */
public class SentenceSlidingActivity extends AppCompatActivity {

    // UI elements for displaying the words and sentences
    private ViewPager2 wordViewPager;
    private SentencePagerAdapter adapter;
    private TextView englishSentenceTextView;
    private Button nextSentenceButton;
    // Lists of English sentences and their corresponding Spanish words
    private List<String> englishSentences;
    private List<List<String>> spanishWords;
    // Tracks the current sentence index
    private int currentSentenceIndex = 0;
    // Indicates the type of deck (regular or hard version)
    private String deckType;

    /**
     * onCreate is called when the activity is first created. It initializes the UI components,
     * sets up the sentence data based on the deck type, and handles the logic for displaying
     * the sentences and Spanish words.
     * Time complexity: O(1) - Initializing UI components and basic setup is constant time.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the saved state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_sliding);

        // Get the deck type (e.g., "Sentences" or "Hard") from the Intent to determine the set of sentences
        deckType = getIntent().getStringExtra("deckName");

        // Initialize the views from the layout
        wordViewPager = findViewById(R.id.wordViewPager);              // O(1)
        englishSentenceTextView = findViewById(R.id.englishSentenceTextView); // O(1)
        nextSentenceButton = findViewById(R.id.nextSentenceButton);    // O(1)

        // Load sentences and words based on the selected deck type
        if (deckType.equals("Sentences")) {
            loadSimpleSentences(); // O(1) - Load the simple sentences deck
        }

        // Load the first sentence and its corresponding words
        loadSentence(currentSentenceIndex); // O(1)
        // Set up the ViewPager with the Spanish words of the first sentence
        adapter = new SentencePagerAdapter(spanishWords.get(currentSentenceIndex)); // O(1)
        wordViewPager.setAdapter(adapter); // O(1)
        // Set up the click listener for the "Next Sentence" button to load the next sentence
        nextSentenceButton.setOnClickListener(v -> {
            // Move to the next sentence
            currentSentenceIndex++; // O(1)

            // Check if more sentences are available
            if (currentSentenceIndex < englishSentences.size()) { // O(1)
                // Load the next sentence and update the adapter with new Spanish words
                loadSentence(currentSentenceIndex);  // O(1)
                adapter.updateWords(spanishWords.get(currentSentenceIndex)); // O(n), where n is the number of words
            } else {
                // If all sentences are completed, show a completion message
                Toast.makeText(this, "You have completed all sentences!", Toast.LENGTH_LONG).show(); // O(1)
                nextSentenceButton.setVisibility(View.GONE); // O(1) - Hide the "Next Sentence" button
            }
        });
    }

    /**
     * Loads a predefined set of simple sentences in English and their corresponding Spanish words.
     * This is used for the regular "Sentences" deck.
     * Time complexity: O(1) - Simple initialization of lists.
     */
    private void loadSimpleSentences() {
        // List of simple English sentences
        englishSentences = Arrays.asList(
                "I speak Spanish with my friend in the park.",
                "They eat bread and drink water while talking.",
                "We live in a big house near the mountains."
        ); // O(1)

        // Corresponding Spanish words for each sentence
        spanishWords = new ArrayList<>(); // O(1)
        spanishWords.add(Arrays.asList("Yo", "hablo", "español", "con", "mi", "amigo", "en", "el", "parque.")); // O(1)
        spanishWords.add(Arrays.asList("Ellos", "comen", "pan", "y", "beben", "agua", "mientras", "hablan.")); // O(1)
        spanishWords.add(Arrays.asList("Nosotros", "vivimos", "en", "una", "casa", "grande", "cerca", "de", "las", "montañas.")); // O(1)
    }

    /**
     * Loads the next sentence and displays the corresponding Spanish words in the ViewPager.
     * This method updates the displayed English sentence and makes the "Next Sentence" button visible.
     * Time complexity: O(1) - Loading and updating the UI with the new sentence and words is constant time.
     *
     * @param sentenceIndex The index of the sentence to be displayed.
     */
    private void loadSentence(int sentenceIndex) {
        // Display the English sentence for the given index
        englishSentenceTextView.setText(englishSentences.get(sentenceIndex)); // O(1)

        // Make the "Next Sentence" button visible in case it was hidden
        nextSentenceButton.setVisibility(View.VISIBLE); // O(1)
    }
}
