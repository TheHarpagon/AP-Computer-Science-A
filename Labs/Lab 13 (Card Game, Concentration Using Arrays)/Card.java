public class Card {
    public int face;
    public int suit;
    public boolean isFaceUp;

    public Card () {
        face = 1;
        suit = 1;
        isFaceUp = false;
    }

    public Card (int suit, int face, boolean isFaceUp) {
        this.suit = suit;
        this.face = face;
        this.isFaceUp = isFaceUp;
    }

    public String cardToString() {
        // if gven card/suit is invalid
        if (suit < 1 || suit > 13 || face > 4 && face < 1) {
            return "  ";
        }
        
        // if the card is not facing up
        else if (isFaceUp == false) {
            return "??";
        } 
        
        // converting the facing up valid card into a String object
        else {
            String[] suits = {"S", "H", "C", "D"};
            String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K"};  
            return suits[face - 1] + faces[suit - 1];
        }
    }
}