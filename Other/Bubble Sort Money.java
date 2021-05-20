class Main {
    public static void main(String[] args) {
        int[][] monies = { { 1, 50 }, { 2, 30 }, { 1, 0 }, { 2, 5 } };
        bubbleSortMoney(monies);
        for (int i = 0; i < monies.length; i++)
            System.out.println(moneyToString(monies[i]));
    }

    public static int dollars(int[] money) {
        return money[0];
    } // end dollars()

    public static int cents(int[] money) {
        return money[1];
    } // end of cents()

    public static String moneyToString(int[] money) {
        if (cents(money) < 10)
            return "$" + dollars(money) + ".0" + cents(money);

        return "$" + dollars(money) + "." + cents(money);
    } // end of moneyToString()

    public static boolean isGreaterThan(int[] m1, int[] m2) {
        return 100 * dollars(m1) + cents(m1) > 100 * dollars(m2) + cents(m2);
    } // end of isGreatherThan()

    public static void bubbleSortMoney(int[][] monies) {
        for (int i = 0; i < money.length - 1; i++) {
            for (int j = 0; j < money.length - i - 1; j++) {
                if (money[j] > money[j+1]) {
                    int tempValue = money[j];
                    money[j] = money[j+1];
                    money[j+1] = tempValue;
                }
            }
        }
    }
}