import java.util.Scanner;

public class Concentration {
    public static void printBoard(Card[][] cardArr) {
        int rowLength = cardArr.length;
        int colLength = cardArr[0].length;
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
        for (int i = 0; i < rowLength; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < colLength; j++) {
                if (cardArr[i][j].cardToString().equals("  ")){
                    System.out.print("   ");
                }
                else if (cardArr[i][j].cardToString().equals("??")){
                    System.out.print("?? ");
                }
                else
                    System.out.print(cardArr[i][j].cardToString() + " ");
            }
            System.out.println();
        }
    }
    
    public static void printBoardFaceUp(Card[][] deck) {
        for (int i = 0; i < deck.length; i++) {
            for (int j = 0; j < deck[0].length; j++) {
                deck[i][j].isFaceUp = true;
            }
        }
        printBoard(deck);
    }

    public static void shuffle (Card[] deck) {
        int randomIndex = 0;
        for (int i = 0; i < deck.length; i++) {
            randomIndex = (int)(Math.random() *52);
            // swap algorithm
            if (!deck[i].cardToString().equals("  ")){
                Card temp = deck[i];
                deck[i] = deck[randomIndex];
                deck[randomIndex] = temp;
            }
        }
    }

    public static Card[] createRandomDeck(){
        Card deck[] = new Card[52];
        int faceVal = 1;
        int suitVal = 1;
        // Populate
        for (int i = 0; i < 52; i++) {
            deck[i] = new Card(faceVal, suitVal, false);
            if (suitVal == 13) {
                faceVal++;
                suitVal = 1;
            }
            else
                suitVal++;
        }
        // Shuffle
        shuffle(deck);
        return deck;
    }

    public static Card[][] createRandomBoard(){
        Card[] deck = createRandomDeck();
        int numRows = 7;
        int numCols = 8;
        int count = 0;
        Card[][] board = new Card[numRows][numCols];
        for (int i = 0 ; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (count < 52)
                    board[i][j] = deck[count];
                else if (count < 56)
                    board[i][j] = new Card();
                count++;
            }
        }
        return board;
    }

    public static void play(){
        Scanner scanner = new Scanner(System.in);
        Card[][] randomBoard = createRandomBoard();
        System.out.println("\n\nRandom Board:");
        printBoard(randomBoard);
        
        int player = 1;
        int cards = 52;
        int row;
        int column;
        int score[] = {0, 0};
        
        Card card1;
        Card card2;
        
        /* similar to a while loop where the contents will
        be executed at least one time, while a while loop will 
        execute when the condition in it is not met
        */
        do {
            System.out.println("Turn for Player " + player);
            System.out.println("Select the first card's row, then column");
            row = scanner.nextInt();
            column = scanner.nextInt();
            row--;
            column--;
            card1 = randomBoard[row][col];
            randomBoard[row][col].isFaceUp = true;
            System.out.println("\n\nRandom Board:");
            printBoard(randomBoard);
            System.out.println("Select the second card's row, then column");
            row = scanner.nextInt();
            column = scanner.nextInt();
            row--;
            column--;
            card2 = randomBoard[row][column];
            randomBoard[row][column].isFaceUp = true;
            System.out.println("\n\nRandom Board is:");
            printBoard(randomBoard);
            
            if (card1.suit == card2.suit) {
                System.out.println("Player " + player + " Wins This Round !!!");
                for(int i = 0; i < randomBoard.length; i++){
                    for(int j= 0;j < randomBoard[0].length;j++){
                        if (randomBoard[i][j].cardToString().equals(card1.cardToString()) || randomBoard[i][j].cardToString().equals(card2.cardToString())){
                            randomBoard[i][j] = new Card();
                        }
                    }
                }
                score[player - 1] += 1; 
                cards -= 2;
            }
            
            else {
                card1.isFaceUp = false;
                card2.isFaceUp = false;
                if (player == 1)
                    player = 2;
                else
                    player = 1;
            }
        }
        
        while (cards > 0);
        System.out.println("Results:");
        int winner = 0;
        int max = 0;
        for (int i = 0; i < 2; i++) {
            if (score[i] > max) {
                max = score[i];
                winner = (i + 1);
            }
            System.out.println("Player " + (i + 1) + ": " + score[i]);
        }
        System.out.println("Player " + winner +" Wins!!!");
    }
}