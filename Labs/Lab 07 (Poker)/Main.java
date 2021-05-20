import java.util.Scanner;

class Main {
    
    // Main Function
    public static void main(String[] args) {
        int card = 13;
        System.out.println("face(): \n" + face(card) + "\n");
        System.out.println("suit(): \n" + suit(card) + "\n");
        System.out.println("cardToString(): \n" + cardToString(card) + "\n");
        int[] cards = {1, 13, 26, 39, 52};
        System.out.println("cardsToString(): \n" + cardsToString(cards) + "\n");
        System.out.println("shuffle(): \nVoid Function \n");
        System.out.println("createShuffledDeck(): \n" + createShuffledDeck() + "\n");
        int[] deck = new int[52];
        System.out.println("nextCard(): \n" + nextCard(deck) + "\n");
        System.out.println("task8():");
        task8();
        System.out.println();
        System.out.println("bestPokerHand(): \n" + bestPokerHand(cards) + "\n");
        int hand = 1;
        System.out.println("pokerHand(): \n" + pokerHand(hand) + "\n");
        System.out.println("play():");
        play();
    }

    // Task #1
    public static int face(int card) {
        int rv = card % 13;
        
        if (rv == 0) {
            return 13;
        }

        return rv;
    }

    // Task #2
    public static int suit(int card) {
        int rv = card / 13;
        
        // if the card is not the last one a suit, it adds one to rv following a conditional statement of modulo division
        if (card % 13 != 0) {
            return rv + 1;
        }
        else {
            return rv;
        }
    }
    
    // Task #3
    public static String cardToString(int card) {
        String rv = "";
        int face = face(card);
        int suit = suit(card);

        String suits[] = {"S", "H", "C", "D"};
        
        // array for suits is ran through for matches and assigned to rv
        for (int i = 1; i <= 4; i++) {
            if (suit == i)
                rv = suits[i - 1];
        }

        String faces[] = {"X", "J", "Q", "K"};

        // runs through the if and else if statement if it's 1 - 9
        if (face == 1)
            rv += "A";
        
        else if (face >= 2 && face <= 9) {
            rv += face;
        }
        
        // runs through only for special cards from 10 - 13
        else {
            for (int j = 10; j <= 13; j++) {
                if (face == j) {
                    rv += faces[j - 10];
                }
            }
        }
        
        return rv;
    }

    // Task #4
    public static String cardsToString(int[] cards) {
        // checks if it's empty
        if (cards == null) {
            return "[]";
        }
        
        String rv = "[";
        
        // converts each index value to a card string layout using cardToString()
        for (int i = 0; i < cards.length; i++) {
            rv += cardToString(cards[i]);
            if (i != cards.length - 1) {
                rv += ", ";
            }
        }

        rv += "]";
        return rv;
    }

    // Task #5
    public static void shuffle(int[] deck) {
        int randomIndex = 0;
        
        for (int i = 0; i < deck.length; i++) {
            // Math.random() returns a value between 0 - 1.0
            // it's multiplied by 52 to give us a value from 0-52
            // the (int) acts as like round() in python
            randomIndex = (int)(Math.random() * deck.length);
            // temporarily stores value of deck to a var
            // assigns that card to the card of a new index
            // card of that new index is assigned to temp variable
            int temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // Task #6
    public static int[] createShuffledDeck() {
        int[] deck = new int[52];
        
        // assigns the deck with values {1, 2, 3, ...}
        for (int i = 0; i < 52; i++) {
            deck[i] = i + 1;
        }

        // shuffles it as if they are the dealer, and returns the deck
        shuffle(deck);
        return deck;
    }

    // Task #7
    public static int nextCard(int[] deck) {
        for (int i = 0; i < deck.length; i++) {
            // runs the loop till there is a filled index in the array, and instantly returns
            // also changes that specific index's value to 0
            if (deck[i] != 0) {
                int rv  = deck[i];
                deck[i] = 0;
                return rv;
            }
        }

        // returns zero if the deck has run out
        return 0;
    }

    // Task #8
    public static void task8() {
        int[] deck = createShuffledDeck();
        // print's the entire deck in the cardsToString() format
        System.out.println(cardsToString(deck));
        
        
        for (int i = 0; i < 5; i++) {
            System.out.println(cardToString(deck[i]));
        }

        System.out.println("Initial Run BPV: 9");
    }
    
    // Task #9
    public static int bestPokerHand(int[] hand) {
        // swap algorithm (sorting the cards)
        for (int i = 0; i < hand.length; i++) {
            for (int j = i + 1; j < hand.length; j++) {
                if (hand[i] > hand[j]) {
                    int temp = hand[i];
                    hand[i] = hand[j];
                    hand[j] = temp;
                }
            }
        }

        // defining major characteristics for the poker hand values
        boolean isFiveContinuous = true;
        boolean sameSuit = true;
        int same = 1;
        
        // loops to run through and check for the bool's possibility of being true or false
        for (int i = 0; i < hand.length - 1; i++) {
            if (face(hand[i + 1]) != face(hand[i] + 1)) {
                isFiveContinuous = false;
            }
        }
        
        for (int i = 0; i < hand.length - 1; i++) {
            if (suit(hand[i]) != suit(hand[i + 1])) {
                sameSuit = false;
                break;
            }
            
        }
        
        for (int i = 0; i < hand.length - 1; i++){
            if (face(hand[i]) == face(hand[i+1]))
                same++;
            
            else
                same = 1;
        }
        
        // all flushes
        if (sameSuit) {
            // royal flush
            if (face(hand[0]) == 1 && face(hand[1]) == 10 && face(hand[2]) == 11 && face(hand[3]) == 12 && face(hand[4]) == 13)
                return 1;
            
            // straight flush
            else if (isFiveContinuous)
                return 2;
            
            // regular flush
            else
                return 5;
        }
        
        // conditions to return values pairs, straight flush, and full house
        else if (isFiveContinuous)
            return 6;
        
        else if (same == 4)
            return 4;
        
        else if (same == 3) {
            if (face(hand[0]) == face(hand[1]) && face(hand[1]) != face(hand[2]))
                return 4;
            
            else if (face(hand[hand.length - 1]) == face(hand[hand.length - 2]) && face(hand[hand.length - 2]) != face(hand[hand.length - 3]))
                return 4;
            
            else
                return 7;
        }
        
        // returns the last two pairs, and the no pattern poker value
        else if (same == 2) {
            int pair = 0;
            for(int i = 0; i < hand.length - 1; i++) {
                if (face(hand[i]) == face(hand[i + 1])) {
                    pair++;
                }
            }
            
            if (pair == 1)
                return 9;
            
            else
                return 8;
        }
        
        else
            return 10;
    }

    // Task #10
    public static String pokerHand(int hand) {
        String[] pokerHandValue = {"Royal Flush", "Straight Flush", "Four of a Kind", "Full House", "Flush", "Straight", "Three of a Kind", "Two Pair", "One Pair", "High Card"};
        return pokerHandValue[hand - 1];
    }
    
    // Task #11
    public static void play() {
        int[] deck = createShuffledDeck();
        int[] handA = new int[5];
        int[] handB = new int[5];

        int j = 0;
        int k = 0;
        
        // dealing players cards from deck[] alternately
        for (int i = 0; i <= 9; i++) {
            // handA gets the even indexes (using modulo divison)
            if (i % 2 == 0) {
                handA[j] = deck[i];
                j++;
            }
            
            // handB gets the odd indexes
            else {
                handB[k] = deck[i];
                k++;
            }
        }

        // Player 1's Turn
        System.out.println("Player 1's Cards: \n" + cardsToString(handA));
        Scanner playerOneInput = new Scanner(System.in);

        int[] playerOneArray = new int[5];

        // runs until they do not press zero
        int l = 0;
        int playerOneChoice = -1;
        while (playerOneChoice != 0) {
            System.out.println();
            System.out.println("Player 1 \nEnter a card # to replace (1 - 5) \nEnter 0 to pass");
            playerOneChoice = playerOneInput.nextInt();
            playerOneArray[l] = playerOneChoice;
            l++;
        }

        int m = 0;
        int n = 10;
        
        // runs until they user press zero and assigns values to their array
        while (playerOneArray[m] != 0) {
            handA[playerOneArray[m] - 1] = deck[n];
            m++;
            n++;
        }

        System.out.println();
        System.out.println("Player 1's Cards: \n" + cardsToString(handA));

        // Player 2's Turn
        System.out.println();
        System.out.println("Player 2's Cards: \n" + cardsToString(handB));
        Scanner playerTwoInput = new Scanner(System.in);

        int[] playerTwoArray = new int[5];

        // runs until they user press zero and assigns values to their array
        int o = 0;
        int playerTwoChoice = -1;
        while (playerTwoChoice != 0) {
            System.out.println();
            System.out.println("Player 2 \nEnter a card number to replace (1 - 5) \nEnter 0 to pass");
            playerTwoChoice = playerTwoInput.nextInt();
            playerTwoArray[o] = playerTwoChoice;
            o++;
        }

        int p = 0;
        // runs loop till the end for te replace choice of player two
        // n will be picked up from player one's turn so the deck is decreased from it's previous value
        while (playerTwoArray[p] != 0) {
            handB[playerTwoArray[p] - 1] = deck[n];
            p++;
            n++;
        }

        System.out.println();
        System.out.println("Player 2's Cards: \n" + cardsToString(handB));

        // checking which player wins using the task #9 function
        System.out.println();
        System.out.println(bestPokerHand(handA));
        System.out.println(bestPokerHand(handB));
        System.out.println();
        
        // lowest value from bestPokerHand() function wins
        if (bestPokerHand(handA) < bestPokerHand(handB))
            System.out.println("Player 1 Wins!");
        
        else if (bestPokerHand(handA) == bestPokerHand(handB))
            System.out.println("Tie!");
        
        else
            System.out.println("Player 2 Wins!");
    }
}