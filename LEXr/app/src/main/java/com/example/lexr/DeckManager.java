package com.example.lexr;
/*
 * @author Daniel Sanchez
 * @version demo
 * @date last modified 9/29/2024 DRS
 * CS 458 Team demo: Kyle, Zoe, Daniel
 */
import java.util.ArrayList;
import java.util.List;

/**
 * DeckManager is a class that manages all decks of cards.
 * It provides methods to load, retrieve, and interact with decks and their associated cards.
 * Simplifies access and reduces memory consumption.
 */
public class DeckManager {

    // Static instance
    private static DeckManager instance;
    // List to store all the decks
    private final List<com.example.lexr.Deck> allDecks;

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the list of all decks and loads the predefined decks.
     * Time complexity: O(1) for initializing the list; O(m) for loading decks where m is the total number of cards across all decks.
     */
    private DeckManager() {
        allDecks = new ArrayList<>();  // Initialize the list to hold all decks O(1)
        loadAllDecks();  // Call method to load predefined decks O(m)
    }

    /**
     * Provides the singleton instance of DeckManager.
     * Ensures only one instance of DeckManager exists.
     * Time complexity: O(1) for checking or creating the instance.
     *
     * @return The singleton instance of DeckManager.
     */
    public static DeckManager getInstance() {
        if (instance == null) {
            instance = new DeckManager();  // Create the instance if it doesn't exist O(1)
        }
        return instance;  // Return the singleton instance O(1)
    }

    /**
     * Loads predefined decks with cards into the system.
     * This is a private helper method that initializes decks with cards.
     * I want to use sql lite to replace the hardcoded portion here.
     * Time complexity: O(m), where m is the total number of cards added across all decks.
     */
    private void loadAllDecks() {
        // Load Spanish Deck 1 with some example cards
        com.example.lexr.Deck spanishDeck1 = new com.example.lexr.Deck("SpanishDeck1");
        // Add cards with words, conjugates, and translations for Spanish Deck 1
        spanishDeck1.addCard(new com.example.lexr.Card("Hablar", List.of("Hablo", "Hablas", "Habla"), "To Speak"));
        spanishDeck1.addCard(new com.example.lexr.Card("Comer", List.of("Como", "Comes", "Come"), "To Eat"));
        spanishDeck1.addCard(new com.example.lexr.Card("Beber", List.of("Bebo", "Bebes", "Bebe"), "To Drink"));
        spanishDeck1.addCard(new com.example.lexr.Card("Vivir", List.of("Vivo", "Vives", "Vive"), "To Live"));
        spanishDeck1.addCard(new com.example.lexr.Card("Correr", List.of("Corro", "Corres", "Corre"), "To Run"));
        spanishDeck1.addCard(new com.example.lexr.Card("Leer", List.of("Leo", "Lees", "Lee"), "To Read"));
        spanishDeck1.addCard(new com.example.lexr.Card("Escribir", List.of("Escribo", "Escribes", "Escribe"), "To Write"));
        spanishDeck1.addCard(new com.example.lexr.Card("Abrir", List.of("Abro", "Abres", "Abre"), "To Open"));
        spanishDeck1.addCard(new com.example.lexr.Card("Cerrar", List.of("Cierro", "Cierras", "Cierra"), "To Close"));
        spanishDeck1.addCard(new com.example.lexr.Card("Estudiar", List.of("Estudio", "Estudias", "Estudia"), "To Study"));
        spanishDeck1.addCard(new com.example.lexr.Card("Caminar", List.of("Camino", "Caminas", "Camina"), "To Walk"));
        spanishDeck1.addCard(new com.example.lexr.Card("Mirar", List.of("Miro", "Miras", "Mira"), "To Watch"));
        spanishDeck1.addCard(new com.example.lexr.Card("Oir", List.of("Oigo", "Oyes", "Oye"), "To Hear"));
        spanishDeck1.addCard(new com.example.lexr.Card("Traer", List.of("Traigo", "Traes", "Trae"), "To Bring"));
        spanishDeck1.addCard(new com.example.lexr.Card("Decir", List.of("Digo", "Dices", "Dice"), "To Say"));
        spanishDeck1.addCard(new com.example.lexr.Card("Dar", List.of("Doy", "Das", "Da"), "To Give"));
        spanishDeck1.addCard(new com.example.lexr.Card("Tomar", List.of("Tomo", "Tomas", "Toma"), "To Take"));
        spanishDeck1.addCard(new com.example.lexr.Card("Dormir", List.of("Duermo", "Duermes", "Duerme"), "To Sleep"));
        spanishDeck1.addCard(new com.example.lexr.Card("Venir", List.of("Vengo", "Vienes", "Viene"), "To Come"));
        spanishDeck1.addCard(new com.example.lexr.Card("Ir", List.of("Voy", "Vas", "Va"), "To Go"));
        // Add more cards to SpanishDeck1 as needed
        allDecks.add(spanishDeck1);  // Add SpanishDeck1 to the list of all decks

        // Load Spanish Deck 2 with example cards
        com.example.lexr.Deck spanishDeck2 = new com.example.lexr.Deck("SpanishDeck2");
        spanishDeck2.addCard(new com.example.lexr.Card("Cantar", List.of("Canto", "Cantas", "Canta"), "To Sing"));
        spanishDeck2.addCard(new com.example.lexr.Card("Escuchar", List.of("Escucho", "Escuchas", "Escucha"), "To Listen"));
        spanishDeck2.addCard(new com.example.lexr.Card("Ganar", List.of("Gano", "Ganas", "Gana"), "To Win"));
        spanishDeck2.addCard(new com.example.lexr.Card("Perder", List.of("Pierdo", "Pierdes", "Pierde"), "To Lose"));
        spanishDeck2.addCard(new com.example.lexr.Card("Saltar", List.of("Salto", "Saltas", "Salta"), "To Jump"));
        spanishDeck2.addCard(new com.example.lexr.Card("Nadar", List.of("Nado", "Nadas", "Nada"), "To Swim"));
        spanishDeck2.addCard(new com.example.lexr.Card("Comprar", List.of("Compro", "Compras", "Compra"), "To Buy"));
        spanishDeck2.addCard(new com.example.lexr.Card("Vender", List.of("Vendo", "Vendes", "Vende"), "To Sell"));
        spanishDeck2.addCard(new com.example.lexr.Card("Llevar", List.of("Llevo", "Llevas", "Lleva"), "To Carry"));
        spanishDeck2.addCard(new com.example.lexr.Card("Hacer", List.of("Hago", "Haces", "Hace"), "To Do/Make"));
        spanishDeck2.addCard(new com.example.lexr.Card("Pensar", List.of("Pienso", "Piensas", "Piensa"), "To Think"));
        spanishDeck2.addCard(new com.example.lexr.Card("Entender", List.of("Entiendo", "Entiendes", "Entiende"), "To Understand"));
        spanishDeck2.addCard(new com.example.lexr.Card("Conocer", List.of("Conozco", "Conoces", "Conoce"), "To Know"));
        spanishDeck2.addCard(new com.example.lexr.Card("Saber", List.of("Sé", "Sabes", "Sabe"), "To Know (Fact)"));
        spanishDeck2.addCard(new com.example.lexr.Card("Creer", List.of("Creo", "Crees", "Cree"), "To Believe"));
        spanishDeck2.addCard(new com.example.lexr.Card("Poder", List.of("Puedo", "Puedes", "Puede"), "To Be Able"));
        spanishDeck2.addCard(new com.example.lexr.Card("Querer", List.of("Quiero", "Quieres", "Quiere"), "To Want"));
        spanishDeck2.addCard(new com.example.lexr.Card("Amar", List.of("Amo", "Amas", "Ama"), "To Love"));
        spanishDeck2.addCard(new com.example.lexr.Card("Llegar", List.of("Llego", "Llegas", "Llega"), "To Arrive"));
        spanishDeck2.addCard(new com.example.lexr.Card("Salir", List.of("Salgo", "Sales", "Sale"), "To Leave"));
        // Add more cards to SpanishDeck2 as needed
        allDecks.add(spanishDeck2);  // Add SpanishDeck2 to the list of all decks

        // Load Spanish Deck 3 with example cards
        com.example.lexr.Deck spanishDeck3 = new com.example.lexr.Deck("SpanishDeck3");
        spanishDeck3.addCard(new com.example.lexr.Card("Ver", List.of("Veo", "Ves", "Ve"), "To See"));
        spanishDeck3.addCard(new com.example.lexr.Card("Tocar", List.of("Toco", "Tocas", "Toca"), "To Touch"));
        spanishDeck3.addCard(new com.example.lexr.Card("Correr", List.of("Corro", "Corres", "Corre"), "To Run"));
        spanishDeck3.addCard(new com.example.lexr.Card("Aprender", List.of("Aprendo", "Aprendes", "Aprende"), "To Learn"));
        spanishDeck3.addCard(new com.example.lexr.Card("Viajar", List.of("Viajo", "Viajas", "Viaja"), "To Travel"));
        spanishDeck3.addCard(new com.example.lexr.Card("Llorar", List.of("Lloro", "Lloras", "Llora"), "To Cry"));
        spanishDeck3.addCard(new com.example.lexr.Card("Reír", List.of("Río", "Ríes", "Ríe"), "To Laugh"));
        spanishDeck3.addCard(new com.example.lexr.Card("Cocinar", List.of("Cocino", "Cocinas", "Cocina"), "To Cook"));
        spanishDeck3.addCard(new com.example.lexr.Card("Bailar", List.of("Bailo", "Bailas", "Baila"), "To Dance"));
        spanishDeck3.addCard(new com.example.lexr.Card("Despertar", List.of("Despierto", "Despiertas", "Despierta"), "To Wake Up"));
        spanishDeck3.addCard(new com.example.lexr.Card("Acostar", List.of("Acuesto", "Acuestas", "Acuesta"), "To Go to Bed"));
        spanishDeck3.addCard(new com.example.lexr.Card("Rezar", List.of("Rezo", "Rezas", "Reza"), "To Pray"));
        spanishDeck3.addCard(new com.example.lexr.Card("Gritar", List.of("Grito", "Gritas", "Grita"), "To Shout"));
        spanishDeck3.addCard(new com.example.lexr.Card("Limpiar", List.of("Limpio", "Limpias", "Limpia"), "To Clean"));
        spanishDeck3.addCard(new com.example.lexr.Card("Luchar", List.of("Lucho", "Luchas", "Lucha"), "To Fight"));
        spanishDeck3.addCard(new com.example.lexr.Card("Trabajar", List.of("Trabajo", "Trabajas", "Trabaja"), "To Work"));
        spanishDeck3.addCard(new com.example.lexr.Card("Pagar", List.of("Pago", "Pagas", "Paga"), "To Pay"));
        spanishDeck3.addCard(new com.example.lexr.Card("Responder", List.of("Respondo", "Respondes", "Responde"), "To Respond"));
        spanishDeck3.addCard(new com.example.lexr.Card("Buscar", List.of("Busco", "Buscas", "Busca"), "To Search"));
        spanishDeck3.addCard(new com.example.lexr.Card("Encontrar", List.of("Encuentro", "Encuentras", "Encuentra"), "To Find"));
        // Add more cards to SpanishDeck3 as needed
        allDecks.add(spanishDeck3);  // Add SpanishDeck3 to the list of all decks

        // Load Spanish Nouns Deck (Deck 4) with example cards
        com.example.lexr.Deck spanishNounsDeck = new com.example.lexr.Deck("SpanishDeck4");
        spanishNounsDeck.addCard(new com.example.lexr.Card("Casa", List.of("La casa"), "House (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Perro", List.of("El perro", "La perra"), "Dog (masculine/feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Gato", List.of("El gato", "La gata"), "Cat (masculine/feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Mesa", List.of("La mesa"), "Table (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Libro", List.of("El libro"), "Book (masculine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Silla", List.of("La silla"), "Chair (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Niño", List.of("El niño", "La niña"), "Boy/Girl (masculine/feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Coche", List.of("El coche"), "Car (masculine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Flor", List.of("La flor"), "Flower (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Amigo", List.of("El amigo", "La amiga"), "Friend (masculine/feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Puerta", List.of("La puerta"), "Door (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Zapato", List.of("El zapato"), "Shoe (masculine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Manzana", List.of("La manzana"), "Apple (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Sombrero", List.of("El sombrero"), "Hat (masculine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Cama", List.of("La cama"), "Bed (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Pez", List.of("El pez"), "Fish (masculine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Reloj", List.of("El reloj"), "Clock (masculine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Ventana", List.of("La ventana"), "Window (feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Estudiante", List.of("El estudiante", "La estudiante"), "Student (masculine/feminine)"));
        spanishNounsDeck.addCard(new com.example.lexr.Card("Profesor", List.of("El profesor", "La profesora"), "Teacher (masculine/feminine)"));
        // Add more cards to SpanishNounsDeck as needed
        allDecks.add(spanishNounsDeck);  // Add SpanishDeck4 to the list of all decks

        // Add cards to Latin Deck
        com.example.lexr.Deck latinDeck = new com.example.lexr.Deck("LatinDeck");
        latinDeck.addCard(new com.example.lexr.Card("Amo", List.of("Amo", "Amas", "Amat"), "To Love"));
        latinDeck.addCard(new com.example.lexr.Card("Porto", List.of("Porto", "Portas", "Portat"), "To Carry"));
        latinDeck.addCard(new com.example.lexr.Card("Specto", List.of("Specto", "Spectas", "Spectat"), "To Watch"));
        latinDeck.addCard(new com.example.lexr.Card("Audio", List.of("Audio", "Audis", "Audit"), "To Hear"));
        latinDeck.addCard(new com.example.lexr.Card("Voco", List.of("Voco", "Vocas", "Vocat"), "To Call"));
        latinDeck.addCard(new com.example.lexr.Card("Doceo", List.of("Doceo", "Doces", "Docet"), "To Teach"));
        latinDeck.addCard(new com.example.lexr.Card("Venio", List.of("Venio", "Venis", "Venit"), "To Come"));
        latinDeck.addCard(new com.example.lexr.Card("Maneo", List.of("Maneo", "Manes", "Manet"), "To Stay"));
        latinDeck.addCard(new com.example.lexr.Card("Capio", List.of("Capio", "Capis", "Capit"), "To Take"));
        latinDeck.addCard(new com.example.lexr.Card("Scribo", List.of("Scribo", "Scribis", "Scribit"), "To Write"));
        latinDeck.addCard(new com.example.lexr.Card("Lego", List.of("Lego", "Legis", "Legit"), "To Read"));
        latinDeck.addCard(new com.example.lexr.Card("Ambulo", List.of("Ambulo", "Ambulas", "Ambulat"), "To Walk"));
        latinDeck.addCard(new com.example.lexr.Card("Ludo", List.of("Ludo", "Ludis", "Ludit"), "To Play"));
        latinDeck.addCard(new com.example.lexr.Card("Curro", List.of("Curro", "Curris", "Currit"), "To Run"));
        latinDeck.addCard(new com.example.lexr.Card("Cogo", List.of("Cogo", "Cogis", "Cogit"), "To Collect"));
        latinDeck.addCard(new com.example.lexr.Card("Peto", List.of("Peto", "Petis", "Petit"), "To Seek"));
        latinDeck.addCard(new com.example.lexr.Card("Mitto", List.of("Mitto", "Mittis", "Mittit"), "To Send"));
        latinDeck.addCard(new com.example.lexr.Card("Duco", List.of("Duco", "Ducis", "Ducit"), "To Lead"));
        latinDeck.addCard(new com.example.lexr.Card("Sto", List.of("Sto", "Stas", "Stat"), "To Stand"));
        latinDeck.addCard(new com.example.lexr.Card("Ago", List.of("Ago", "Agis", "Agit"), "To Do"));
        allDecks.add(latinDeck);
    }  //decks need different method of storage --to be worked on

    /**
     * Returns the list of all decks managed by DeckManager.
     * Time complexity: O(1) - Returning the reference to the list is constant time.
     *
     * @return A list of all decks.
     */
    public List<com.example.lexr.Deck> getAllDecks() {
        return allDecks;  // Return the list of all decks O(1)
    }

    /**
     * Retrieves all the favorite cards from all decks.
     * Time complexity: O(n * m), where n is the number of decks and m is the average number of cards per deck.
     *
     * @return A list of favorite cards from all decks.
     */
    public List<com.example.lexr.Card> getFavoriteCards() {
        List<com.example.lexr.Card> favoriteCards = new ArrayList<>();  // Initialize the list to store favorite cards O(1)

        // Iterate through each deck O(n), where n is the number of decks
        for (com.example.lexr.Deck deck : allDecks) {
            // For each deck, iterate through its cards O(m), where m is the number of cards in the deck
            for (com.example.lexr.Card card : deck.getCards()) {
                if (card.isFavorite()) {
                    favoriteCards.add(card);  // Add the card if it's a favorite O(1) (amortized)
                }
            }
        }
        return favoriteCards;  // Return the list of favorite cards O(1)
    }

    /**
     * Retrieves a specific deck by its name.
     * Time complexity: O(n), where n is the number of decks.
     *
     * @param deckName The name of the deck to retrieve.
     * @return The Deck object if found, or null if not found.
     */
    public com.example.lexr.Deck getDeckByName(String deckName) {
        // Iterate through all decks to find the one with the matching name O(n)
        for (com.example.lexr.Deck deck : allDecks) {
            if (deck.getLanguage().equals(deckName)) {
                return deck;  // Return the deck if found O(1)
            }
        }
        return null;  // Return null if the deck is not found O(1)
    }
}
