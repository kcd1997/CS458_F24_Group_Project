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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * SentencePagerAdapter is a custom adapter for a RecyclerView that displays a list of words
 * in the form of a ViewPager. It helps in showing Spanish words in a sentence for the matching game.
 */
public class SentencePagerAdapter extends RecyclerView.Adapter<SentencePagerAdapter.WordViewHolder> {

    // List of words (Spanish words) to be displayed
    private List<String> words;

    /**
     * Constructor to initialize the adapter with a list of words.
     * Time complexity: O(1) - Assigning a reference to the list of words is constant time.
     *
     * @param words The list of words to display in the ViewPager.
     */
    public SentencePagerAdapter(List<String> words) {
        this.words = words; // O(1)
    }

    /**
     * Called when the RecyclerView needs a new ViewHolder to represent a word item.
     * This method inflates the layout for individual word items.
     * Time complexity: O(1) - Inflating the layout and creating a ViewHolder is constant time.
     *
     * @param parent The parent ViewGroup into which the new view will be added.
     * @param viewType The view type of the new view.
     * @return A new WordViewHolder that holds the view for each word item.
     */
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single word item from XML
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false); // O(1)
        return new WordViewHolder(view); // O(1)
    }

    /**
     * Called by the RecyclerView to display the data at the specified position.
     * This method updates the contents of the ViewHolder with the word at the given position.
     * Time complexity: O(1) - Accessing an element from the list and updating the UI is constant time.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the word.
     * @param position The position of the word within the list.
     */
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        // Get the word at the current position and set it to the TextView
        String word = words.get(position); // O(1)
        holder.wordTextView.setText(word); // O(1)
    }

    /**
     * Returns the total number of words in the list.
     * Time complexity: O(1) - Returning the size of the list is constant time.
     *
     * @return The size of the words list.
     */
    @Override
    public int getItemCount() {
        return words.size(); // O(1)
    }

    /**
     * Updates the list of words and notifies the adapter that the data has changed.
     * This method allows the ViewPager to be refreshed with a new set of words.
     * Time complexity: O(n) - Where n is the number of words. Updating the reference is O(1),
     * but notifying the adapter and re-binding the views is O(n) because it reprocesses the data set.
     *
     * @param newWords The new list of words to be displayed.
     */
    public void updateWords(List<String> newWords) {
        this.words = newWords; // O(1)
        notifyDataSetChanged(); // O(n), where n is the number of words to refresh
    }

    /**
     * ViewHolder class that holds the view for each individual word item in the RecyclerView.
     * It contains a single TextView that displays the word.
     */
    static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView wordTextView; // TextView to display the word

        /**
         * Constructor for WordViewHolder that initializes the TextView for the word.
         * Time complexity: O(1) - Finding views by ID is constant time.
         *
         * @param itemView The view of the word item.
         */
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find the TextView for displaying the word in the item layout
            wordTextView = itemView.findViewById(R.id.wordTextView); // O(1)
        }
    }
}
