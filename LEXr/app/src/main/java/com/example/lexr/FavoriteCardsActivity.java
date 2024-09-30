package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;

/**
 * FavoriteCardsActivity is an activity that displays a user's favorite cards using a ViewPager2.
 * The favorite cards are retrieved from all the available decks and displayed for the user.
 */
public class FavoriteCardsActivity extends AppCompatActivity {

    private ViewPager2 favoriteViewPager;  // ViewPager2 widget to swipe between favorite cards
    private CardPagerAdapter adapter;      // Adapter to manage the display of cards in ViewPager2

    /**
     * Called when the activity is first created. Sets up the ViewPager and loads favorite cards.
     * Time complexity: O(n * m) - where n is the number of decks and m is the average number of cards per deck. This is due to retrieving favorite cards from all decks.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down, this Bundle contains the saved state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_cards); // Set the layout for this activity O(1)

        // Initialize the ViewPager for displaying favorite cards
        favoriteViewPager = findViewById(R.id.favoriteViewPager);  // O(1)

        // Retrieve favorite cards from the DeckManager
        List<Card> favoriteCards = DeckManager.getInstance().getFavoriteCards();  // O(n * m) where n is the number of decks and m is the number of cards per deck

        // Set up the adapter for the ViewPager if there are any favorite cards
        if (!favoriteCards.isEmpty()) {
            adapter = new CardPagerAdapter(favoriteCards);  // Initialize the adapter with favorite cards O(1)
            favoriteViewPager.setAdapter(adapter);  // Set the adapter to the ViewPager O(1)
        } else {
            // Optionally display a message if no favorite cards are selected
            Toast.makeText(this, "No favorite cards selected", Toast.LENGTH_SHORT).show();  // O(1)
        }
    }
}
