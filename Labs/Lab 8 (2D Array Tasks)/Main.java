class Main {
  public static void main(String[] args) {
    // all declared arrays
    int[] a = {1, 2, 3};
    int[][] b = {{1, 2, 3}, {3, 4, 5, 6}, {7, 8, 9, 9, 9}};
    int[][] c = {{-1, -1, 1}, {-1, 1, -1}, {1, -1, -1}};
    int[][] d = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}, {3, 4, 5, 6}};
    int[][] e = {{1, 2, 3}, {4, 5, 6}};
    int[][] f = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    // running all functions
    System.out.println("arrayToString(int[] array): \n" + arrayToString(a) + "\n");
    System.out.println("arrayToString(int[][] array): \n" + arrayToString(b) + "\n");
    System.out.println("ticTacToe(int[][] array): \n" + ticTacToe(c) + "\n");
    System.out.println("totalSum(int[][] array): \n" + totalSum(b) + "\n");
    System.out.println("majorDiagonalSum(int[][] array): \n" + majorDiagonalSum(d) + "\n");
    System.out.println("minorDiagonalSum(int[][] array): \n" + minorDiagonalSum(d) + "\n");
    System.out.println("min(int[] array): \n" + min(a) + "\n");
    System.out.println("min(int[][] array): \n" + min(b) + "\n");
    System.out.println("min2(int[][] array): \n" + min2(b) + "\n");
    System.out.println("rotate2DArray(int[][] array): \n" + arrayToString(rotate2DArray(f)) + "\n");
    System.out.println("abcPatterns(int number): ");
    abcPatterns(5);
    System.out.println("\nexpand2DArray(int[][] array): \n" + arrayToString(expand2DArray(e)) + "\n");
    System.out.println("pascalsTriangle(int number): \n" + arrayToString(pascalsTriangle(5)));
  }

  public static String arrayToString(int[] array) {
    if (array == null)
      return "null";
    String rv = "";
    
    for  (int i = 0; i < array.length; i++) {
      if (i == 0)
        rv += array[i];
      else
        rv += ", " + array[i];
    }
    
    return "{" + rv + "}";
  }
  
  public static String arrayToString(int[][] array) {
    if (array == null)
      return "null";
    String rv = "";
    
    for (int i = 0; i < array.length; i++) {
      if (i == 0)
        rv += arrayToString(array[i]);
      else
        rv += ",\n " + arrayToString(array[i]);
    }
    
    return "{" + rv + "}";
  }

  public static String ticTacToe(int[][] array) {
    boolean isTicTacToe = true;
    
    // checking in all rows
    for (int i = 0; i < array.length; i++) {
      isTicTacToe = true;
      for (int j = 0; j < array[0].length - 1; j++) {
        if (array[i][j] != array[i][j + 1]) {
          isTicTacToe = false;
          break;
        }
      }
      if (isTicTacToe == true) {
        return "Found (Row)";
      }
    }
    
    // checking in all columns
    for (int k = 0; k < array[0].length; k++) {
      isTicTacToe = true;
      for (int l = 0; l < array.length - 1; l++) {
        if (array[l][k] != array[l + 1][k]) {
          isTicTacToe = false;
          break;
        }
      }
      if (isTicTacToe == true) {
        return "Found (Column)";
      }
    }
    
    // checking both diagonals
    isTicTacToe = true;
    // major diagonal
    for (int m = 0; m < array.length - 1; m++) {
      if (array[m][m] != array[m + 1][m + 1]) {
        isTicTacToe = false;
        break;
      }
    }
    
    if (isTicTacToe == true) {
      return "Found (Diagonal)";
    }

    // minor diagonal
    isTicTacToe = true;
    for (int n = 0; n < array.length - 1; n++) {
      if (array[n][array.length - n - 1] != array[n + 1][array.length - n - 2]) {
        isTicTacToe = false;
        break;
      }
    }
    if (isTicTacToe == true) {
      return "Found (Diagonal)";
    }
    // not found if tic tac toe is not found
    return "Not Found";
  }

	public static int totalSum(int[][] array) {
    int rv = 0;
    
    // goes through each element and adds it to rv
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        rv += array[i][j];
      }
    }
    
    return rv;
  }
  
  public static int majorDiagonalSum(int[][] array) {
    int rv = 0;
    // goes from top left to bottom right adding the values into rv
    for (int i = 0; i < array.length; i++) {
      rv += array[i][i];
    }
    return rv;
  }

  public static int minorDiagonalSum(int[][] array) {
    int rv = 0;
    // goes from top right to bottom left adding the values into rv
    for (int i = 0; i < array.length; i++) {
      rv += array[i][array.length - i - 1];
    }
    return rv;
  }

  public static int min(int[] array) {
    int rv = array[0];
    // checks each element of the array with rv, which is remapped every time in the loop
    for (int i = 1; i < array.length; i++) {
      if (array[i] < rv)
        rv = array[i];
    }
    return rv;
  }

  public static int min(int[][] array) {
    int rv = min(array[0]);
    // same thing as min(int[] array) except it's for each row and columns of the array since it's 2D
    for (int i = 0; i < array.length; i++) {
      if (min(array[i]) < rv)
        rv = min(array[i]);
    }
    return rv;
  }

  public static int min2(int[][] array) {
    int rv = array[0][0];
    // same thing as min(int[][] array) except you can't use the min(int[]) function, just reqrote the logic and used a nested for loop
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] < rv)
          rv = array[i][j];
      }
    }
    return rv;
  }

  public static int[][] rotate2DArray(int[][] array) {
    // find the sectors which need to be transposed
    for(int i = 0; i < 3; i++) { 
      for(int j = 0; j < i; j++){
        int temp = array[i][j];
        array[i][j] = array[j][i];
        array[j][i] = temp;
      }
    }

    // interchange first and third column
    for (int k = 0; k < 3; k++) { 
      int temp2 = array[k][0]; 
      array[k][0] = array[k][2]; 
      array[k][2] = temp2;
    }
    
    return array;
  }

  public static void abcPatterns(int number) {
    // pattern A
    System.out.print("A)" + "\n");
    for (int i = 1; i <= number; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j);
      }
      System.out.println();
    }
    
    // pattern B
    System.out.println();
    System.out.print("B)" + "\n");
    for (int i = number; i >= 1; i--) {
      for (int j = i; j >= 1; j--) {
        System.out.print(j);
      }
      System.out.println();
    }
    
    // pattern C
    System.out.println();
    System.out.print("C)" + "\n");
    int k = 1;
    for (int i = number; i >= 1; i--) {
      for (int j = 1; j <= k; j++) {
        System.out.print(i);
      }
      System.out.println();
      k++;
    }
  }

  public static int[][] expand2DArray(int[][] array) {
    // expanding the rv's length to double that of int c[][]
    int[][] rv = new int[(array.length) * 2][(array[1].length) * 2];
    int l = 0;
    
    // filing in the expanded array's indexes
    for (int i = 0; i < array.length; i++) {
      int k = 0;
      for (int j = 0; j < array[i].length; j++) {
        rv[l][k] = array[i][j];
        rv[l][k + 1] = array[i][j];
        k = k + 2;
      }
      rv[l + 1] = rv[l];
      l = l + 2;
    }
    
    return rv;
  }

  public static int[][] pascalsTriangle(int number) {
    // decleration of the jagged array with a unspecified amount of columns
    int[][] rv = new int[number][];
    
    // putting the correct amount of columns in each row (ex: row 1, 1 column, row 2, 2 columns, etc.)
    for (int c = 0; c < number; c++) {
      rv[c] = new int[c + 1];
    }

    // triangle logic
    for (int i = 0; i < number; i++) {
      for (int j = 0; j <= i; j++) {
        // adding a check if it's the first/second row
        if(j == 0 || j == i)
          rv[i][j] = 1;
        else {
          // adding the sums of the previous row and placing in the current row
          rv[i][j] = rv[i - 1][j - 1] + rv[i - 1][j];
        }
      }
    }
    
    return rv;
  }
}