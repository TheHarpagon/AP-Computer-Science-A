class Main {
    public static void main(String[] args) {
        // createMoney()
        int[] a = createMoney(4, 115);
        System.out.println("[#1] createMoney(): " + a[0] + " " + a[1]);

        // copyMoney()
        int[] b = copyMoney(a);
        a[1] = 50;
        System.out.println("[#2] copyMoney(): " + a[0] + " " + a[1]);
        System.out.println("[#2.1] copyMoney(): " + b[0] + " " + b[1]);

        // dollars()
        System.out.println("[#3] dollars(): " + dollars(a));

        // cents()
        System.out.println("[#4] cents(): " + cents(a));

        // moneyToString()
        System.out.println("[#5] moneyToString(): " + moneyToString(a));
        b = createMoney(1, 2);
        System.out.println("[#5.1] moneyToString(): " + moneyToString(b));

        // moneyToText()
        System.out.println("[#6] moneyToText(): " + moneyToText(a));

        // isGreater()
        System.out.println("[#7] isGreater(): " + isGreaterThan(a, b));

        // isEqual()
        System.out.println("[#8] isEqual(): " + isEqual(a, b));

        // adder()
        a = createMoney(1, 10);
        b = createMoney(2, 20);
        adder(a, b);
        System.out.println("[#9] adder(): " + moneyToString(a));
        System.out.println("[#9.1] adder(): " + moneyToString(b));

        // add()
        b = add(a, b);
        System.out.println("[#10] add(): " + moneyToString(a));
        System.out.println("[#10.1] add(): " + moneyToString(b));

        // subber()
        a = createMoney(2, 10);
        b = createMoney(2, 20);
        subber(a, b);
        System.out.println("[#11] subber(): " + moneyToString(a));
        System.out.println("[#11.1] sub(): " + moneyToString(b));

        // sub()
        b = sub(a, b);
        System.out.println("[#12] sub(): " + moneyToString(a));
        System.out.println("[#12.1] sub(): " + moneyToString(b));

        // payWith20()
        a = createMoney(5, 12);
        b = createMoney(3, 91);
        System.out.println("[#13] payWithO20(): " + moneyToString(payWith20(a)));
        System.out.println("[#13.1] payWithO20(): " + moneyToString(payWith20(b)));

        // applpyInterest()
        a = createMoney(3, 25);
        int i = 5;
        System.out.println("[#14] applyInterest(): " + moneyToString(applyInterest(a, i)));

    } // end of main()

    public static int[] createMoney(int d, int c) {
        int[] returnValue = new int[2];

        while (c > 99) {
            d++;
            c -= 100;
        }

        returnValue[0] = d;
        returnValue[1] = c;

        return returnValue;
    } // end of createMoney()

    public static int[] copyMoney(int[] money) {
        int[] returnValue = new int[money.length];
        for (int i = 0; i < money.length; i++)
            returnValue[i] = money[i];

        return returnValue;
    } // end of copMoney()

    public static int dollars(int[] money) {
        int returnValue = 0;
        returnValue = money[0];
        return returnValue;
    } // end of dollars()

    public static int cents(int[] money) {
        int returnValue = 0;
        returnValue = money[1];
        return returnValue;
    } // end of cents()

    public static String moneyToString(int[] m) {
        String returnValue;

        if (m[1] < 10)
            returnValue = "$" + m[0] + ".0" + m[1];

        else
            returnValue = "$" + m[0] + "." + m[1];

        return returnValue;
    } // end of moneyToString()

    public static String moneyToText(int[] money) {
        String returnValue = "";
        String[] hundreds = { "one hundred ", "two hundred ", "three hundred ", "four hundred ", "five hundred ",
                "six hundred ", "seven hundred ", "eight hundred ", "nine hundred " };
        String[] tens = { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        String[] ones = { " one", " two", " three", " four", " five", " six", " seven", " eight", " nine" };
        String[] tensAlone = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };

        // converting dollars to text
        int dollarsOnesPlace = dollars(money) % 10;
        int dollarsTensPlace = (dollars(money) / 10) % 10;
        int dollarsHundredsPlace = ((dollars(money) / 100)) % 10;
        int dollarsTensOnesAlone = dollars(money) % 100;

        if (dollarsHundredsPlace == 0) {
            if (dollarsTensPlace == 0)
                returnValue += ones[dollarsOnesPlace - 1];

            else
                returnValue += (tens[dollarsTensPlace - 1] + ones[dollarsOnesPlace - 1]);
        }

        else if (dollarsTensPlace == 0) {
            if (dollarsOnesPlace == 0)
                returnValue += hundreds[dollarsHundredsPlace - 1];

            else
                returnValue += (hundreds[dollarsHundredsPlace - 1] + ones[dollarsOnesPlace - 1]);
        }

        else if (dollarsOnesPlace == 0)
            returnValue += (hundreds[dollarsHundredsPlace - 1] + tens[dollarsTensPlace - 1]);

        else if ((dollarsTensOnesAlone > 10) && (dollarsTensOnesAlone < 20))
            returnValue += (hundreds[dollarsHundredsPlace - 1] + tensAlone[dollarsTensOnesAlone - 11]);

        else
            returnValue += (hundreds[dollarsHundredsPlace - 1] + tens[dollarsTensPlace - 1]
                    + ones[dollarsOnesPlace - 1]);

        returnValue += " dollars and ";

        // converting cents to text
        int centsOnesPlace = cents(money) % 10;
        int centsTensPlace = (cents(money) / 10) % 10;
        int centsTensOnesPlace = cents(money) % 100;

        if (centsTensPlace == 0)
            returnValue += ones[centsOnesPlace - 1];

        else if (centsOnesPlace == 0)
            returnValue += tens[centsTensPlace - 1];

        else if ((centsTensOnesPlace > 10) && (centsTensOnesPlace < 20))
            returnValue += tensAlone[centsTensOnesPlace - 11];

        else
            returnValue += tens[centsTensPlace - 1] + ones[centsOnesPlace - 1];

        returnValue += " cents";

        return returnValue;
    } // end of moneyToText()

    public static boolean isGreaterThan(int[] m1, int[] m2) {
        boolean returnValue = false;

        if (m1[0] > m2[0])
            returnValue = true;

        else if (m1[0] < m2[0])
            returnValue = false;

        else {
            if (m1[1] > m2[1])
                returnValue = true;

            else if (m1[1] < m2[1])
                returnValue = false;
        }

        return returnValue;
    } // end of isgreaterThan()

    public static boolean isEqual(int[] m1, int[] m2) {
        boolean returnValue = false;

        if (m1[0] == m2[0] && m1[1] == m2[1])
            returnValue = true;

        return returnValue;
    } // end of isEqual()

    public static void adder(int[] m1, int[] m2) {
        m1[0] += m2[0];
        m1[1] += m2[1];

        m1 = createMoney(m1[0], m1[1]);
    } // end of adder()

    public static int[] add(int[] m1, int[] m2) {
        int[] returnValue = new int[2];

        returnValue[0] = m1[0] + m2[0];
        returnValue[1] = m1[1] + m2[1];
        returnValue = createMoney(returnValue[0], returnValue[1]);

        return returnValue;
    } // end of add()

    public static void subber(int[] m1, int[] m2) {
        if (m1[1] < m2[1]) {
            m1[0] -= 1;
            m1[1] += 100;
        }

        m1[0] -= m2[0];
        m1[1] -= m2[1];

        m1 = createMoney(m1[0], m1[1]);
    } // end of createMoney()

    public static int[] sub(int[] m1, int[] m2) {
        int[] returnValue = new int[2];

        if (m1[1] < m2[1]) {
            m1[0] -= 1;
            m1[1] += 100;
        }

        returnValue[0] = m1[0] - m2[0];
        returnValue[1] = m1[1] - m2[1];
        returnValue = createMoney(returnValue[0], returnValue[1]);

        return returnValue;
    } // end of sub()

    public static int[] payWith20(int[] owe) {
        int[] returnValue = new int[2];
        returnValue[0] = 19 - owe[0];
        returnValue[1] = 100 - owe[1];

        return returnValue;
    } // end of payWith20()

    public static int[] applyInterest(int[] balance, int interest) {
        int[] returnValue = new int[2];
        balance[0] *= 100;
        balance[1] *= 100;
        balance[0] += balance[0] * (interest * (1 / 100));
        balance[1] += balance[1] * (interest * (1 / 100));
        returnValue[0] = balance[0] / 100;
        returnValue[1] = (balance[0] % 100) + (balance[1] / 100);

        return returnValue;
    } // end of applyInterest()

}