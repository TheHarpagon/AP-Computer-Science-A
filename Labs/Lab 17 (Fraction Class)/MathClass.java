public class MathClass {
  // constants (final static variables)
  public static final double E = 2.72;
  public static final double PI = 3.14;

  // static/class variables
  private static int count = 0;

  // nonstatic/instance variables

  // constructors
  public MathClass () {
    
  }

  // getters/setters
  public static int getCount () {
    return count;
  }

  // static methods
  public static double abs (double value) {
    count++;
    if (value < 0)
      return -value;
    return value;
  }

  public static String abs (int value) {
    count++;
    return "|" + value + "|";
  }

  // nonstatic methods
  public double absNS (double value) {
    count++;
    if (value < 0)
      return -value;
    return value;
  }

  public String absNS (int value) {
    count++;
    return "|" + value + "|";
  }

  public int sqrtNS (int value) {
    count++;
    value = (int) (absNS(((double) (value))));
    int i = 0;
    for (;(i * i) < value; i++);
    if ((i * i) == value)
      return i;
    return i - 1;
  }
}