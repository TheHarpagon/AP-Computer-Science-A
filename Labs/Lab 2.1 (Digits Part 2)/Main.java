class Main {
    public static void main(String[] args) {
          int[] a = {6, 7, 8, 9};
          System.out.println(combineDigits(a));
          System.out.println(replaceDigit(789123, 5, 3));
    } // end main()
  
    public static int combineDigits(int[] a) {
        int i = 0;
        int expNumber = 1;
        int arrayLength = a.length;
        int finalNumber = 0;
        
        for (int j = 1; j < arrayLength; j++) {
            expNumber *= 10;
        }
        
        while (i < arrayLength) {
            if (i > 0)
                expNumber /= 10;
            finalNumber = finalNumber + (a[i] * expNumber);
            i++;
        }

        return finalNumber;

    } // end combineDigits()
      
    public static int replaceDigit(int number, int newValue, int digitPosition) {
        int arrayLength = 0;
        int a_copy = number;
        int mod;
        int i = 0;

        while(a_copy > 0) {
            a_copy /= 10;
            arrayLength++;
        }
  
      int[] numberArray = new int[arrayLength];
      
        while(number > 0) {
            mod = number % 10;
            numberArray[numberArray.length-1-i] = mod;
            number /= 10;
            i++;
        }
  
      numberArray[(numberArray.length - 1) - digitPosition] = newValue;
      int rv = combineDigits(numberArray);
      return rv;
      } // end replaceDigit()
  }