public class Main {
    public static void main(String[] args) {
        int rows = 7;
        int columns = 8;
        Card[][] cardArray = new Card[rows][columns];
        int suitVal = 1;
        int faceVal = 1;
        int cardCount = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cardCount < 52) {
                    Card card = new Card(suitVal, faceVal, true);
                    cardArray[i][j] = card;
                    if (faceVal == 13) {
                        suitVal++;
                        faceVal = 1;
                    }
                    else
                        faceVal++;
                }
                else {
                    cardArray[i][j] = new Card();
                }
                cardCount++;
            }
        }
        
        Concentration.printBoard(cardArray);
    }
}