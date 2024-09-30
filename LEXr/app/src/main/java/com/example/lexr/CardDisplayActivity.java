package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.lexr.CardPagerAdapter;
import com.example.lexr.Deck;
import com.example.lexr.Deck;
import java.util.List;

/**
 * CardDisplayActivity handles the display of vocabulary cards using a ViewPager.
 * Users can swipe through the cards to see the word, conjugates, and translations.
 */
public class CardDisplayActivity extends AppCompatActivity {

    // Fields to store the current deck, the ViewPager, and the adapter for card display
    private Deck currentDeck;         // The current deck being displayed
    private ViewPager2 viewPager;     // The ViewPager that handles swiping through cards
    private CardPagerAdapter adapter; // Adapter to supply card data to the ViewPager
    private Button shuffleButton;
    private List<Card> originalOrder;
    /**
     * Called when the activity is created. It sets up the UI and initializes the deck and adapter.
     * Time complexity: O(n) - The time complexity of this method depends on the size of the deck (n),
     * as it involves fetching the deck and setting up the adapter with the cards.
     *
     * @param savedInstanceState Bundle containing the activity's previously saved state (if any).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_display);

        String deckName = getIntent().getStringExtra("deckName");
        currentDeck = DeckManager.getInstance().getDeckByName(deckName);

        viewPager = findViewById(R.id.viewPager);
        originalOrder = currentDeck.getCards(); // Save the original order of the deck
        adapter = new CardPagerAdapter(currentDeck.getCards());
        viewPager.setAdapter(adapter);

        shuffleButton = findViewById(R.id.shuffleButton);
        shuffleButton.setOnClickListener(v -> {
            currentDeck.shuffleDeck(); // Shuffle the deck
            adapter.notifyDataSetChanged(); // Refresh the adapter
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Restore the original order of the deck when the activity is destroyed
        currentDeck.setCards(originalOrder);
    }
}
