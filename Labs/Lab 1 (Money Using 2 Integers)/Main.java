class Main {
  public static void main(String[] args) {
    System.out.println(moneyToString(0, 0));
    printSum(1, 22, 3, 44);
    System.out.println(biggestMoney(1,1,2,2,3,3));
    printChangeFrom20(3, 75);
  }
  public static String moneyToString(int d, int c) {
  String rv = "";
  String zero = "";
  if(c < 10)
    zero = "0";
  rv = "$" + d + "." + zero + c;
  return rv;
  } // end moneyToString() Function
  public static void printSum(int d1, int c1, int d2, int c2) {
  int totalDollars = 0, totalCents = 0;
  totalDollars = d1 + d2;
  totalCents = c1 + c2;
  if (totalCents > 100) {
    totalCents -= 100;
    totalDollars += 1;
  }
  System.out.println(moneyToString(totalDollars, totalCents));
  } // end printSum() Function
  public static int biggestMoney(int d1, int c1, int d2, int c2, int d3, int c3){
  int rv = 1;
  int penny1 = 100 * d1 + c1, penny2 = 100 * d2 + c2, penny3 = 100 * d3 + c3;
  if (penny2 > penny1)
    rv = 2;
  if ((penny3 > penny2) && (penny3 > penny1)) {
    rv = 3;
  }
  
  return rv;
  } // end biggestMoney() Function
  public static void printChangeFrom20(int d, int c){
    int changeD = 0, changeC = 0;
    changeD = 20 - d;
    changeC = 0 - c;
    while(changeC < 0){
      changeC += 100;
      changeD --;
    }
    System.out.println(moneyToString(changeD, changeC));
  } // end printChangeFrom20() Function
}