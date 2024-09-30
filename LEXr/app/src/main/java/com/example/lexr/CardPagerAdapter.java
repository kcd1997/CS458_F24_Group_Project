package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * CardPagerAdapter is a RecyclerView adapter that binds vocabulary cards to the view for display.
 * It supports flipping cards and marking them as favorites.
 */
public class CardPagerAdapter extends RecyclerView.Adapter<CardPagerAdapter.CardViewHolder> {

    private final List<com.example.lexr.Card> cardList;  // List of cards to be displayed

    /**
     * Constructor for the adapter, taking a list of cards.
     * Time complexity: O(1) - Assigning a reference to the card list is a constant time operation.
     *
     * @param cardList The list of Card objects to be displayed in the RecyclerView.
     */
    public CardPagerAdapter(List<com.example.lexr.Card> cardList) {
        this.cardList = cardList;  // Initialize the list of cards
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     * Inflates the layout for individual card items.
     * Time complexity: O(1) - Inflating the layout and creating a new ViewHolder happens in constant time.
     *
     * @param parent   The parent ViewGroup into which the new view will be added.
     * @param viewType The view type of the new View.
     * @return A new CardViewHolder that holds the view for each card.
     */
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the card_item layout to create the view for each card
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);  // Return a new ViewHolder for the card
    }

    /**
     * Called by RecyclerView to display data at a specific position.
     * Binds the card data to the ViewHolder.
     * Time complexity: O(1) - Accessing the card list and binding the data for each card is constant time.
     *
     * @param holder   The ViewHolder that should be updated to represent the card.
     * @param position The position of the item within the card list.
     */
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        com.example.lexr.Card card = cardList.get(position);  // Get the card at the given position O(1)
        holder.bind(card);  // Bind the card data to the ViewHolder O(1)
    }

    /**
     * Returns the total number of cards in the list.
     * Time complexity: O(1) - Returning the size of the list is constant time.
     *
     * @return The size of the card list.
     */
    @Override
    public int getItemCount() {
        return cardList.size();  // Return the total number of cards O(1)
    }

    /**
     * ViewHolder class for individual card items in the RecyclerView.
     * It holds references to the views for each card's content and handles user interactions.
     */
    public static class CardViewHolder extends RecyclerView.ViewHolder {

        // Views in the card item layout
        private final TextView wordView;
        private final TextView conjugatesView;
        private final TextView translationView;  // TextViews for displaying card data
        private final ImageView favoriteIcon;  // ImageView to represent the favorite icon

        /**
         * Constructor for the CardViewHolder.
         * Finds the views in the item layout and assigns them to fields.
         * Time complexity: O(1) - Finding views by their IDs is a constant time operation.
         *
         * @param itemView The View representing the card item.
         */
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);  // Call the superclass constructor

            // Find the views in the card_item layout and initialize them
            wordView = itemView.findViewById(R.id.cardWord);
            conjugatesView = itemView.findViewById(R.id.cardConjugates);
            translationView = itemView.findViewById(R.id.cardTranslation);
            favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
        }

        /**
         * Binds the card data to the views and sets up interaction listeners.
         * Time complexity: O(m) - Where m is the number of conjugates for a card (for joining the conjugates string).
         *
         * @param card The Card object to bind to the views.
         */
        public void bind(com.example.lexr.Card card) {
            // Set the word, conjugates, and translation to their respective TextViews
            wordView.setText(card.getWord());  // Set the word on the card O(1)
            conjugatesView.setText(String.join(", ", card.getConjugates()));  // Join and display conjugates O(m) where m is the number of conjugates
            translationView.setText(card.getTranslation());  // Set the translation text O(1)
            translationView.setVisibility(View.GONE);  // Hide the translation initially (card starts unflipped) O(1)

            // Set the favorite icon state based on whether the card is marked as favorite
            if (card.isFavorite()) {
                favoriteIcon.setImageResource(R.drawable.ic_star_filled);  // Display a filled star if the card is a favorite O(1)
            } else {
                favoriteIcon.setImageResource(R.drawable.ic_star_outline);  // Display an empty star if the card is not a favorite O(1)
            }

            // Set up a click listener on the favorite icon to toggle the card's favorite status
            favoriteIcon.setOnClickListener(v -> {
                if (card.isFavorite()) {
                    card.setFavorite(false);  // Unmark the card as favorite O(1)
                    favoriteIcon.setImageResource(R.drawable.ic_star_outline);  // Change the icon to an empty star O(1)
                } else {
                    card.setFavorite(true);  // Mark the card as favorite O(1)
                    favoriteIcon.setImageResource(R.drawable.ic_star_filled);  // Change the icon to a filled star O(1)
                }
            });

            // Set up a click listener on the entire itemView to implement flip card functionality
            itemView.setOnClickListener(v -> {
                if (translationView.getVisibility() == View.GONE) {  // If the translation is hidden, flip the card to show it O(1)
                    translationView.setVisibility(View.VISIBLE);  // Show the translation O(1)
                    conjugatesView.setVisibility(View.GONE);  // Hide the conjugates when the card is flipped O(1)
                } else {  // If the translation is visible, flip the card back O(1)
                    translationView.setVisibility(View.GONE);  // Hide the translation O(1)
                    conjugatesView.setVisibility(View.VISIBLE);  // Show the conjugates again O(1)
                }
            });
        }
    }
}
