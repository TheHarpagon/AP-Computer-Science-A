class Main {
  public static void main(String[] args) {
    System.out.println(onesDigit(1234));
    System.out.println(onesDigit(101010));
    System.out.println(countDigits(10101010));
    System.out.println(countEvenDigits(12340234));
    System.out.println(getDigits(78954,4,2));    
  } // end of main()

  public static int onesDigit(int a) {
    return a % 10;
  } // end of onesDigits()

  public static int tensOnesDigit(int a) {
    return a % 100;
  } // end of tensOnesDigits

  public static int tensDigit(int a) {
    return a % 100 / 10;
  } // end of tensDigits

  public static int hundredsDigit(int a) {
    return a % 1000 / 100;
  } // end of hundredsDigit

  public static int thousandsDigit(int a) {
    return a % 10000 / 1000;
  } // end of thousandsDigit

  public static int countDigits(int a) {
    int digits = 0;
    
    while (a > 0) {
      digits++;
      a /= 10;
    }

    return digits;
  } // end of countDigits()

  public static int countEvenDigits(int a) {
    int digit;
    int count = 0;

    while (a > 0) {
      digit = a % 10;
      a /= 10;
      if (digit % 2 == 0)
        count++;
    }

    return count;
  } // end of countEvenDigits()

  public static int countOddDigits(int a) {
    return countDigits(a) - countEvenDigits(a);
  } // end of countOddDigits

  public static int getDigits(int a, int biggestDigit, int smallestDigit) {
    int div = 1;
    int mod = 1;
    int rv;

    while (smallestDigit > 0) {
      div *= 10;
      smallestDigit--;
    }

    while (biggestDigit >= 0) {
      mod *= 10;
      biggestDigit--;
    }

    rv = (a % mod) / div;
    return rv;
  } // end of getDigits()

}