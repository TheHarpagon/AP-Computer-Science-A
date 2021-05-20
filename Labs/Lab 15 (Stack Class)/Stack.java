public class Stack {
  // declaration of the instance variables
  private int[] storage;
  private int numberOfElements;

  // copies an array onto a new one
  public static int[] copyArray (int[] a) {
    int[] rv = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      rv[i] = a[i];
    }
    return rv;
  }

  // stitches two arrays together
  public static int[] append (int[] a, int[] b) {
    if (b == null)
      return copyArray(a);
    if (a == null)
      return copyArray(b);
    int[] rv = new int[a.length + b.length];
    for (int i = 0; i < a.length; i++)
      rv[i] = a[i];
    int j = 0;
    for (int i = a.length; j < b.length; i++) {
      rv[i] = b[j];
      j++;
    }
    return rv;
  }

  // defualt constructor
  public Stack () {
    storage = new int[100];
    numberOfElements = 0;
  }

  // gets array
  public int[] getStorage () {
    return copyArray(storage);
  }

  // gets array element count
  public int getNumberOfElements () {
    return numberOfElements;
  }

  // pushes an element into the array
  public void push (int element) {
    if (numberOfElements == storage.length) {
      int[] array = new int[100];
      storage = append(storage, array);
    }
    storage[numberOfElements] = element;
    numberOfElements++;
  }

  // removes element from the array
  public int pop () {
    if (numberOfElements > 0) {
      numberOfElements--;
      return storage[numberOfElements];
    }

    else {
      return 0;
    }
  }

  // converts the array into a string (eg: "[1, 2, 3,...]")
  public String toString () {
    String rv = "[";
    for (int i = 0; i < numberOfElements; i++)
      rv += storage[i] + ", ";
    if (rv.length() > 1)
      rv = rv.substring(0, rv.length() - 2);
    return (rv + "]");
  }
}