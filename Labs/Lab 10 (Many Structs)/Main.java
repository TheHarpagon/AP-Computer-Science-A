public class Main {
    public static void main (String[] args) {
        testCodeMoney();
        testCodePoint();
    }

    public static String moneyToString (Money m) {
        if (m.cents % 10 == 0)
            return "$" + m.dollars + "." + m.cents + "0";
        
        else
            return "$" + m.dollars + (m.cents / 100.0);
    }

    public static Money add (Money m1, Money m2) {
        int dollars = m1.dollars + m2.dollars;
        int cents = m1.cents + m2.cents;
        if (cents > 99) {
            dollars += cents / 100;
            cents %= 100;
        }
		return new Money(dollars, cents);
	}

    public static Money payWith20 (Money m) {
        int dollars = 19 - m.dollars;
        int cents = 100 - m.cents;
		return new Money(dollars, cents);
	}

    public static Money applyInterest (Money m, double interestRate) {
        double amount = (m.dollars + 0.01 * m.cents) * (1 + interestRate * 0.01);
        int dollars = (int) amount;
		return new Money(dollars, (int) (amount * 100 - dollars * 100));
	}

    public static void testCodeMoney () {
		Money[] array = new Money[100];
        for (int i = 0; i < 100; i++) {
			array[i] = new Money(i + 1);
		}
        //assigning $1.00 to the last value of the array
		array[99].dollars = 1;
        array[99].cents = 0;
        double x = 0; // stores the money sum
        for (int j = 0; j < 100; j++) {
            // adds the matching value of cents in each array index to X
            x += ((double) array[j].cents / 100);
			x += array[j].dollars;//Adds the corresponding cent value of each array term to x
		}
        System.out.println("Money Array Sum: " + x + "\n");
		Money array2 = new Money(0, 0);
		Money tenDollars = new Money(10, 0);
        int day = 1;
        // adding 10 dollars daily
        while (day < 366) {
            array2 = add(array2, tenDollars);
            int[] endOfMonths = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 365};
            for (int i = 0; i < endOfMonths.length; i++) {
			    if (day == endOfMonths[i]) { //Checks for end of every month
                    array2 = applyInterest(array2, .01); // applies the interest to the sum
                    break;
                }
            }
			day++;
        }
        System.out.println("The person has saved " + moneyToString(array2)); // amount saved
        String[] itemList = {"Pop Secret Movie Theater Bttr Popcorn - 38.4 Oz", "Jif Peanut Butter Creamy - 28 Oz", "Bonne Maman Preserves Raspberry - 13 Oz ", "Daves Killer Bread Organic 21 Whole Grains - 27 Oz", "Mission Tortilla Strips Restaurant Style Fiesta Size - 20 Oz"};
        //Creates item list corresponding to each price
		Money[]itemPriceList = new Money[5];//Creates money list with prices of each item
		//Inputs prices into itemPriceList
		itemPriceList[0] = new Money(5, 99);
		itemPriceList[1] = new Money(4, 99);
		itemPriceList[2] = new Money(6, 49);
		itemPriceList[3] = new Money(4, 99);
		itemPriceList[4] = new Money(4, 49);
		// computing the price for the itemList
		Money totalChange = new Money(0, 0);
        for (int j = 0; j < 5; j++) {
			totalChange = add(totalChange, itemPriceList[j]);//Adds prices to sum
		}
        // applies the interest and calculates the totalChange
        totalChange = applyInterest(totalChange, 8.25);
		totalChange = payWith20(totalChange);
		System.out.println("The change from buying" + itemList[0] + " is " + moneyToString(totalChange));
    }

    public static String pointToString (Point p) {
        return ("(" + p.x + "." + p.y + ")");
    }

    public static Point midpoint (Point p1, Point p2) {
        // uses the midpoint formula [(x1 + x2) / 2, (y1 + y2) / 2]
        return new Point((p1.x + p2.x)/2,(p1.y + p2.y)/2);
    }
    
    public static boolean isEqual (Point p1, Point p2) {
        // checks if both points are equivalent in positiion
        if ((p1.x == p2.x) && (p1.y == p2.y))
            return true;
		return false;
    }
    
    public static int quadrant (Point p) {
		// locates what wuadrant the point is in and returns its number
		if (p.x > 0 && p.y > 0) 
			return 1;
		else if (p.x < 0 && p.y > 0)
			return 2;
		else if (p.x < 0 && p.y < 0)
			return 3;
		else if (p.x > 0 && p.y < 0)
			return 4;
		return 0; //Returns quad
    }
    
    public static void verticalStretch (Point p, double a) {
        // multiplies y with a to give it a vertical stretch transformation
		p.y *= a;
    }

    public static void horizontalStretch (Point p, double a) {
        // multiplies y with a to give it a horizontal stretch transformation
		p.x *= a;
    }
    
    public static void verticalShift (Point p, double a) {
        // adds y to a to give it a vertical shift transformation
        p.y += a;
	}
    
    public static void horizontalShift (Point p, double a) {
        // adds x to a to give it a horizontal shift transformation
		p.x += a;
    }
    
    public static void testCodePoint () {
		// mapping to f(x) = 2x + 3
		Point[] p = new Point[5];//Initializes point array
		for (int a = 2; a < 11; a += 2) {
			p[(a - 2) / 2] = new Point(a, 2 * a + 3);
        }
        System.out.println("5A:\n" + p);
        
        // vertical stretch by a factor of 3
		System.out.println("\n5B:");
		for (int b = 0; b < 5; b++) {
			verticalStretch(p[b], 3); //Vertically stretches points in array by a factor of 3
			//Prints out each point
			if (b < 4)
				System.out.println(pointToString(p[b]) + ", ");
			else
				System.out.println(pointToString(p[b]));
		}
        
        // horizontal stretch by a factor of 2
		System.out.println("\n5C:"); //Prints header text
		for (int c = 0; c < 5; c++) {
			horizontalStretch(p[c], 2);
			if (c < 4)
				System.out.println(pointToString(p[c]) + ", ");
			else
				System.out.println(pointToString(p[c]));
		}
		// vertical shift 1 unit down
		System.out.println("\n5D:"); //Prints header text
		for (int d = 0; d < 5; d++) {
			verticalShift(p[d], -1);
			if (d < 4)
				System.out.println(pointToString(p[d]) + ", ");
			else
				System.out.println(pointToString(p[d]));
		}
        
        // horizontal shift 2 units right
		System.out.println("\n5E:");
		for (int e = 0; e < 5; e++) {
			horizontalShift(p[e], 2);
			if (e < 4)
				System.out.println(pointToString(p[e]) + ", ");
			else
				System.out.println(pointToString(p[e]));
		}
        
        // sin function declaration and assignments
		Point[] sinFunction = new Point[5];
		sinFunction[0] = new Point(0, 0);
		sinFunction[1] = new Point(1.57, 1);
		sinFunction[2] = new Point(3.14, 0);
		sinFunction[3] = new Point(4.71, -1);
		sinFunction[4] = new Point(6.28, 0);
        
        // vertical shift 2 units up and a vertical stretch by a factor of 2
		System.out.println("\n5G:");
		for (int g = 0; g < 5; g ++) {
			verticalShift(sinFunction[g], 2);
			verticalStretch(sinFunction[g], 2);
			if (g < 4)
				System.out.println(pointToString(sinFunction[g]) + ", ");
			else
				System.out.println(pointToString(sinFunction[g]));
		}
        
        // vertical stretch by a factor of 2 and a vertical shift 2 units up
		System.out.println("\n5H:");
		for (int h = 0; h < 5; h ++) {
			verticalStretch(sinFunction[h], 2);
			verticalShift(sinFunction[h], 2);
			if (h < 4)
				System.out.println(pointToString(sinFunction[h]) + ", ");
			else
				System.out.println(pointToString(sinFunction[h]));
		}
	}

}