// optional lab
// got it from a friend

public class Main {
	public static void main(String[] args) {
		System.out.println("y = 2x + 3");
		System.out.println("x \t y");
		for(int i = 0; i < 11; i++) {
			System.out.println(i + "\t" + linear(i, 2, 3));
		}
		System.out.println("");
		System.out.println("25 Fibonacci numbers");
		System.out.println("n \t nth Fib number");
		for(int i = 1; i < 26; i++) {
			System.out.println(i + "\t" + fib(i));
		}		
		System.out.println("");
		System.out.println("Number at (5, 4) is: " + pascals(5, 4));
        for(int i = 1; i < 11; i++) {//10 rows
            for(int j = 1; j <= i; j++) {//rows have as many terms as the column number
                System.out.print(pascals(i, j) + " ");//each term in the row printed, followed by a space
            }
            System.out.println("");//new line for every row
        }
        
        System.out.println("");
        System.out.println("y=2x^2+x+1");
        System.out.println(" x \t y");
        for(int i = 0; i < 11; i++) {
        	System.out.println(i + "\t" + quadratic(i, 2, 1, 1));
        }
        
        System.out.println("");
        System.out.println("Alternate Quadratic");
        System.out.println("y=2x^2+x+1");
        System.out.println(" x \t y");
        for(int i = 0; i < 11; i++) {
        	System.out.println(i + "\t" + quadratic(i, 2, 1, 1));
        }
        
        System.out.println("");
        System.out.println(doubleLetters("Hello"));
        
        System.out.println("");
        System.out.println(capVowel("Hello"));
		
        
        System.out.println("");
        System.out.println(reverse("Hello"));
        
        System.out.println("");
        System.out.println(isPallindrome("Hello"));
        System.out.println(isPallindrome("anna"));      
        System.out.println(isPallindrome("a"));
        
        System.out.println("");
        System.out.println(beforeVowel("gog"));
        
        System.out.println("");
        System.out.println(afterVowel("qwdety"));
        
        System.out.println("");
        System.out.println(beforeVowel(" Hello"));
        
        System.out.println("");
        System.out.println(pigLatin("hello world"));
		}
	
	public static int linear(int x, int m, int b) {
		if(x == 0) { // if at x = 0 
			return b; // return the y-intercept
		}
		return linear(x - 1, m, b) + m; // return the previous x values and add the slope
	}
	
	public static int fib(int n) {
		if(n <= 2) { // if position 0, 1, or 2
			return 1; // return the first number of Fibonacci sequence, 1
		}
		return fib(n - 1) + fib(n - 2); // return the sum of the previous and second previous number
	}
	
	public static int pascals(int row, int column) {
		if (column == 1 || column == row) {
			return 1;
		} else {
			return pascals(row - 1, column - 1) + pascals(row - 1, column);
		}
	}
	
	public static int quadratic(int x, int a, int b, int c) {
		if(x == 0) {
			return c;
		}
		return quadratic(x - 1, a, b, c) + (a * 2 * x - 1);
	}
	
	public static int quadratic2(int x, int a, int b, int c) {
		if(x == 0) {
			return c;
		}
		return quadratic(x - 1, a, b, c) + linear(x - 1, a + a, -1) + c;
	}
	
	public static String doubleLetters(String s) {
		if(s.length() == 0) {
			return "";
		}
		return s.substring(0, 1) + s.substring(0, 1) + doubleLetters(s.substring(1));
	}
	
	public static String capVowel(String s) {
		if(s.substring(s.length() - 1).equals("a") || s.substring(s.length() - 1).equals("e") ||
				s.substring(s.length() - 1).equals("i") || s.substring(s.length() - 1).equals("o")|| 
				s.substring(s.length() - 1).equals("u")) {
			if(s.length() == 1) {
				return s.toUpperCase();
			}
			return capVowel(s.substring(0, s.length() - 1)) + s.substring(s.length() - 1).toUpperCase();
		}
		if(s.length() == 1) {
			return s;
		}
		return capVowel(s.substring(0, s.length() - 1)) + s.substring(s.length() - 1);
	}
	
	public static String reverse(String s) {
		if(s.isEmpty()) {
			return s;
		}
		return reverse(s.substring(1)) + s.substring(0, 1);
	}
	
	public static boolean isPallindrome(String s) {
		if(s.length() == 0 || s.length() == 1) {
			return true;
		}
		if(s.substring(0, 1).equals(s.substring(s.length() - 1))) {
			return isPallindrome(s.substring(1, s.length() - 1));
		}
		return false;
	}
	
	public static String beforeVowel(String s) {
		if(s.substring(0, 1).equals("a") || s.substring(0, 1).equals("e") ||
				s.substring(0, 1).equals("i") || s.substring(0, 1).equals("o") || 
				s.substring(0, 1).equals("u") || s.substring(0, 1).equals("A") ||
				s.substring(0, 1).equals("E") || s.substring(0, 1).equals("I") ||
				s.substring(0, 1).equals("O") || s.substring(0, 1).equals("U")) {
			return "";
		}
		if(s.indexOf("a") < 0 && s.indexOf("e") < 0 && s.indexOf("i") < 0 && s.indexOf("o") < 0 &&
				s.indexOf("u")  < 0 && s.indexOf("A") < 0 && s.indexOf("E") < 0 && s.indexOf("I") < 0 && s.indexOf("O") < 0 &&
		s.indexOf("U")  < 0){
			return s;
		}
		return s.substring(0, 1) + beforeVowel(s.substring(1));
	}
	
	public static String afterVowel(String s) {
		if(s.substring(0, 1).equals("a") || s.substring(0, 1).equals("e") ||
				s.substring(0, 1).equals("i") || s.substring(0, 1).equals("o") || 
				s.substring(0, 1).equals("u") || s.substring(0, 1).equals("A") ||
				s.substring(0, 1).equals("E") || s.substring(0, 1).equals("I") ||
				s.substring(0, 1).equals("O") || s.substring(0, 1).equals("U")) {
			return s.substring(1);
		}
		return afterVowel(s.substring(1));
	}
	
	public static String noLeadingWhiteSpace(String s) {
		if(s.substring(0, 1).equals(" ")) {
			return noLeadingWhiteSpace(s.substring(1));
		}
		return s;
	}
	
	public static String beforeSpace(String s) {
		if(s.substring(0, 1).equals(" ")) {
			return "";
		}
		return s.substring(0, 1) + beforeSpace(s.substring(1));
	}
	
	public static String afterSpace(String s) {
		if(s.substring(0, 1).equals(" ")) {
			return s.substring(1);
		}
		return afterSpace(s.substring(1));
	}
	
	public static String pigLatin(String s) {
	     if(s.indexOf(" ") < 0) {
	    	 return s.substring(1) + s.substring(0, 1) + "ay";
	     }
	     return s.substring(1, s.indexOf(" ")) + s.substring(0, 1) + "ay " + pigLatin(s.substring(s.indexOf(" ") + 1));
	   }
}
