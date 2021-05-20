// https://secure-media.collegeboard.org/digitalServices/pdf/ap/ap15_frq_computer_science_a.pdf

// 1A
public static int arraySum(int[] array) {
  int rv = 0;
  for (int i : array)
    rv += i;
  return rv;
}

// 1B
public static int[] rowSums(int[][] matrix) {
  int[] rv = new int[matrix.length]
  int index = 0;
  for (int[] array : matrix) {
    rv[index] = arraySum(array);
    index++;
  }
  return rv;
}

// 1C
public static boolean isDiverse(int[][] arr2D) {
  int[] sums = rowSums(arr2D);
  for (int i = 0; i < sums.length - 1; i++) {
    if (sums[i] == sums[i + 1])
      return false;
  }
  return true;
}

// 2
public class HiddenWord {
  private String word;
  
	public HiddenWord (String word) {
    this.word = word;
  }
  
	public String getHint(String guess) {
    String rv = word;
    for (int i = 0; i < word.length(); i++) {
      if (guess.substring(i, i + 1).equals(word.substring(i, i + 1)))
        rv = rv; // do nothing
      else if (word.indexOf(guess.substring(i, i + 1)) != -1)
        rv.substring(i, i + 1) = "+";
      else
        rv.substring(i, i + 1) = "*";
    }
    return rv;
  }
}

// 3A
public int getValueAt(int row, int col) {
  for (SparseArrayEntry entry : entries) {
    if (entry.getRow() == row && entry.getCol() == col) {
      return entry.getValue();
    }
  }
  return 0;
}

// 3B
public int removeColumnn(int col) {
  for (int i = 0; i < entries.size(); i++) {
    if (entries.get(i).getCol() == col) {
      entries.remove(entries.get(i));
    }
    else if (entries.get(i).getCol() > col) {
      SparseArrayEntry newEntry = new SparseArrayEntry(entries.get(i).getRow(), entries.get(i).getCol() - 1, entries.get(i).getValue());
      entries.remove(entries.get(i));
      entries.add(newEntry);
    }
  }
  numCols--;
}

// 4A
public class NumberGroup {
  private ArrayList<Integer> group;
  public boolean contains (int number) {
    for (int i : group) {
      if (i == number)
        return true;
    }
    return false;
  }
}

// 4B
public Range extends NumberGroup {
  private int min;
  private int max;
  public Range (int min, int max) {
    this.min = min;
    this.max = max;
  }
}

// did not do 4C