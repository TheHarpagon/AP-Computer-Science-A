public class Fraction {
  // constants (final static variables)
  
  // static/class variables
  private static int objectCount = 0;
  private static int methodCount = 0;
  
  // nonstatic/instance variables
  private int numerator;
  private int denominator;
  
  // constructors
  public Fraction () {
    objectCount++;
    numerator = 0;
    denominator = 1;
  }

  public Fraction (int n, int d) {
    objectCount++;
    numerator = n;
    denominator = d;
  }

  public Fraction (Fraction f) {
    objectCount++;
    numerator = f.getNumerator();
    denominator = f.getDenominator();
  }


  
  // getters/setters
  public int getObjectCount () {
    return objectCount;
  }
  
  public int getMethodCount () {
    return methodCount;
  }
  
  public int getNumerator () {
    return numerator;
  }
  
  public int getDenominator () {
    return denominator;
  }

  public void setNumerator (int numerator) {
    this.numerator = numerator;
  }

  public void setDenominator (int denominator) {
    this.denominator = denominator;
  }
  
  // static methods
  public static int integerPart (Fraction f) {
    methodCount++;
    return f.numerator / f.denominator;
  }

  public static int abs (int a) {
    methodCount++;
    if (a < 0)
      return -a;
    return a;
  }

  public static Fraction min (Fraction a, Fraction b) {
    methodCount++;
    if ((double) a.numerator / a.denominator < (double) b.numerator / b.denominator) {
      return new Fraction (a);
    }
    return new Fraction (b);
  }

  public static Fraction max (Fraction a, Fraction b) {
    methodCount++;
    if ((double) a.numerator / a.denominator > (double) b.numerator / b.denominator) {
      return new Fraction (a);
    }
    return new Fraction (b);
  }
  
  // nonstatic methods
  public String toString () {
    methodCount++;
    if (denominator == 1)
      return "" + numerator;
    return numerator + "/" + denominator;
  }

  public String toMixedNumber () {
    methodCount++;
    // if the fraction is equivalent to a whole number
    if (numerator % denominator == 0) {
      return (numerator / denominator) + "";
    }

    // if it is an improper funcion
    else if (numerator > denominator) {
      int whole = numerator / denominator;
      int remainder = numerator % denominator;
      return whole + " " + remainder + "/" + denominator;
    }
    return numerator + "/" + denominator;
  }

  public int integerPart () {
    methodCount++;
    return numerator / denominator;
  }

  public int remainder () {
    methodCount++;
    if (numerator > denominator) {
      return numerator % denominator;
    }
    return 0;
  }

  public boolean isError() {
    methodCount++;
    return denominator == 0;
  }

  public boolean isPositive () {
    methodCount++;
    return ((numerator < 0 && denominator < 0) || (numerator >= 0 && denominator > 0));
  }

  public boolean equals (Fraction f) {
    methodCount++;
    return ((f.numerator / f.denominator) == (numerator / denominator)) && ((f.numerator % f.denominator) == (numerator % denominator));
  }

  public boolean isSimplified() {
    methodCount++;
    if (numerator < 0 && denominator < 0)
      return false;
    
    if (abs(numerator) <= abs(denominator)) {
      int d = 2;
      while (d <= abs(numerator)) {
        if (numerator % d == 0 && denominator % d == 0)
          return false;
        d++;
      }
    }
    
    else {
      int d = 2;
      while (d <= abs(denominator)) {
        if (numerator % d == 0 && denominator % d == 0)
          return false;
        d++;
      }
    }
    return true;
  }

  public void simplify () {
    methodCount++;
    if (!isSimplified()) {
      if (numerator == denominator) {
        numerator = 1;
        denominator = 1;
      }
      else if (abs(numerator) > abs(denominator)) {
        if (abs(numerator) % abs(denominator) == 0) {
          numerator /= denominator;
          denominator = 1;
        }
        else {
          int d = 2;
          while (d < abs(denominator)) {
            if (abs(numerator) % d == 0 && abs(denominator) % d == 0) {
              numerator /= d;
              denominator /= d;
              d = 2;
            }
            else
              d++;
          }
        }
      }
      else {
        if (abs(denominator) % abs(numerator) == 0) {
          denominator /= numerator;
          numerator = 1;
        }
        else {
          int d = 2;
          while (d < abs(numerator)) {
            if (abs(numerator) % d == 0 && abs(denominator) % d == 0) {
              numerator /= d;
              denominator /= d;
              d = 2;
            }
            else
              d++;
          }
        }
      }
    }
    if (numerator < 0 && denominator < 0) {
      numerator = abs(numerator);
      denominator = abs(denominator);
    }
    else if (denominator < 0) {
      numerator *= -1;
      denominator  = abs(denominator);
    }
  }

  public Fraction simplified() {
    methodCount++;
    Fraction f = new Fraction (numerator, denominator);
    f.simplify();
    return f;
  }

  public Fraction sum (Fraction a) {
    methodCount++;
    Fraction f = new Fraction ();
    f.numerator = numerator * a.denominator + a.numerator * denominator;
    f.denominator = denominator * a.denominator;
    f.simplify();
    return f;
  }

  public static Fraction sum (Fraction[] a) {
    methodCount++;
    Fraction f = new Fraction (a[0]);
    for (int i = 1; i < a.length; i++) {
      f = f.sum(a[i]);
    }
    return f;
  }

  public Fraction difference (Fraction a) {
    methodCount++;
    Fraction f = new Fraction ();
    f.numerator = numerator * a.denominator - a.numerator * denominator;
    f.denominator = denominator * a.denominator;
    f.simplify();
    return f;
  }

  public Fraction product (Fraction a) {
    methodCount++;
    Fraction f = new Fraction ();
    f.numerator = numerator * a.numerator;
    f.denominator = denominator * a.denominator;
    f.simplify();
    return f;
  }
  
  public Fraction quotient (Fraction a) {
    methodCount++;
    Fraction f = new Fraction ();
    f.numerator = numerator * a.denominator;
    f.denominator = denominator * a.numerator;
    f.simplify();
    return f;
  }

  public Fraction sqrt () {
    methodCount++;
    Fraction f = new Fraction ();
    MathClass m = new MathClass();
    f.numerator = m.sqrtNS(numerator);
    f.denominator = m.sqrtNS(denominator);
    f.simplify();
    return f;
  }

  public static Fraction[] quadraticFormula(Fraction a, Fraction b, Fraction c) {
    // all the parts of the quadratic formula
    Fraction firstPart = new Fraction(-1*b.numerator, b.denominator);
    Fraction secondPart = b.product(b);
    Fraction thirdPart = a.product(c.product(new Fraction(4,1)));
    Fraction fourthPart = a.product(new Fraction(2,1));
    // checks to return 0, 1, or 2 solutions
    if(secondPart.difference(thirdPart).isPositive()) {
        // gives the 2 solutions if the discriminant is positive
        Fraction[] twoSol = {firstPart.sum((secondPart.difference(thirdPart)).sqrt()).quotient(fourthPart), 
        (firstPart.difference((secondPart.difference(thirdPart)).sqrt())).quotient(fourthPart)};
        return twoSol;
        }
    else if(!secondPart.difference(thirdPart).isPositive()) {
        // gives 1 solution if the discriminant is 0
        if((secondPart.difference(thirdPart)).equals(new Fraction(0,1))) {
            Fraction[] oneSol = {firstPart.quotient(fourthPart)};
            return oneSol;
        }
    }
    // gives no solutions if the discriminant is negative
    Fraction[] noSol = null;
    return noSol;
  }

  public static int[] factors(int n) {
    methodCount++;
    int factorcount = 0;
    int[] factors = new int[n];
    for (int i = 2; i <= n; i++) {
        if (n % i == 0) {
            factors[factorcount] = i;
            factorcount++;
        }
    }
    // modifies the array of factors, which was sized to n for a safe width
    int[] returnArray = new int[factorcount];
    for (int i = 0; i < factorcount; i++)
        returnArray[i] = factors[i];
    return returnArray;
  }

  public Fraction[] partialPartialFractionDecomposition(){
    int[] factors = factors(denominator); // initialize integer array of all possible denominator factors
    Fraction[] rv = new Fraction[factors.length]; // initialize Fraction array length of number of factors
    for (int i = 0; i < factors.length; i++)
      rv[i] = new Fraction(0, factors[i]);
    int t = numerator; // create temporary integer equal to numerator
    for (int i = 0; i < factors.length; i++){ // traverse length of factors array
        int factor = factors[i]; // set factor int equal to positioned factor in the array
        if (t - denominator/factor >= 0){ // if the numerator subtracted by the denominator divided by factor results in 0
          rv[i].setNumerator(1); // set the numerator of that fraction to 1
            t -= denominator/factor; // subtract to find remaining
        }
    }
    return rv;
  }
}