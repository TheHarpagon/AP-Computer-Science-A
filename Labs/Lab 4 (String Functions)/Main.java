class Main {
	public static void main(String[] args) {
		String s = "Hello World!";
		System.out.println("[1] Space Count: " + spaceCount(s));
		System.out.println("[2] Vowel Count: " + vowelCount(s));
		System.out.println("[3] Letter Count: " + letterCount(s, "l"));
		System.out.println("[4] Duplicate String: " + duplicate(s, "l"));
		System.out.println("[5] Before String: " + beforeString(s, "Wo"));
		System.out.println("[6] After String: " + afterString(s, "Wo"));
		System.out.println("[7] Cap Vowel String: " + capVowel(s));
		System.out.println("[8] Cap First Word String: " + capFirstWord(s));
		System.out.println("[9] Is Vowel Boolean: " + isVowel("a"));
		System.out.println("[10] Reverse String: " + reverse(s));
	} // end of main()

	public static int spaceCount(String s) {
		int returnValue = 0;
		while (s.indexOf(" ") != -1) {
			returnValue += 1;
			s = s.substring(s.indexOf(" ") + 1);
		}

		return returnValue;
	} // end of spaceCount()

	public static int vowelCount(String s) {
		int returnValue = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length() - 1; i++) {
			if ((s.substring(i, i + 1)).compareTo("a") == 0 || (s.substring(i, i + 1)).compareTo("e") == 0
					|| (s.substring(i, i + 1)).compareTo("i") == 0 || (s.substring(i, i + 1)).compareTo("o") == 0
					|| (s.substring(i, i + 1)).compareTo("u") == 0) {
				returnValue += 1;
			}
		}

		return returnValue;
	} // end of vowelCount()

	public static int letterCount(String s, String letter) {
		int returnValue = 0;

		while (s.indexOf(letter) != -1) {
			returnValue += 1;
			s = s.substring(s.indexOf(letter) + 1);
		}

		return returnValue;
	} // end of letterCount()

	public static String duplicate(String s, String letter) {
		String returnValue = "";
		for (int i = 0; i < s.length(); i++) {
			String currentLetter = s.substring(i, i + 1);

			if (currentLetter.compareTo(letter) == 0) {
				returnValue += currentLetter + letter;
			}

			else {
				returnValue += currentLetter;
			}
		}

		return returnValue;
	} // end duplicate()

	public static String beforeString(String s, String substr) {
		String returnValue;
		returnValue = s.substring(0, s.indexOf(substr));

		return returnValue;
	} // end of beforeString()

	public static String afterString(String s, String substr) {
		String afterString;
		int stringLength = substr.length();
		afterString = s.substring(s.indexOf(substr) + stringLength);

		return afterString;
	} // end of afterString()

	public static String capVowel(String s) {
		String returnValue = "";
		for (int i = 0; i < s.length() - 1; i++) {
			if ((s.substring(i, i + 1)).compareTo("a") == 0 || (s.substring(i, i + 1)).compareTo("e") == 0
					|| (s.substring(i, i + 1)).compareTo("i") == 0 || (s.substring(i, i + 1)).compareTo("o") == 0
					|| (s.substring(i, i + 1)).compareTo("u") == 0) {
				returnValue += (s.substring(i, i + 1)).toUpperCase();
			}

			else
				returnValue += (s.substring(i, i + 1));
		}

		return returnValue;
	} // end of capVowel()

	public static String capFirstWord(String s) {
		String returnValue = "";
		String letter = "";
		String punctuation = ".?!\n";
		String whiteSpace = " \t";
		boolean lightSwitch = true;
		for (int i = 0; i < s.length(); i++) {
			letter = s.substring(i, i + 1);

			if (lightSwitch == false || whiteSpace.indexOf(letter) >= 0)
				returnValue = returnValue + letter;

			else {
				returnValue = returnValue + letter.toUpperCase();
				lightSwitch = false;
			}

			if (punctuation.indexOf(letter) >= 0)
				lightSwitch = true;
		}

		return returnValue;
	} // end of capFirstWord()

	public static boolean isVowel(String s) {
		s = s.toLowerCase();

		if (s.compareTo("a") == 0 || s.compareTo("e") == 0 || s.compareTo("i") == 0 || s.compareTo("o") == 0
				|| s.compareTo("u") == 0) {
			return true;
		}

		else {
			return false;
		}
	} // end of isVowel()

	public static String reverse(String s) {
		String returnValue = "";
		for (int i = s.length(); i > 0; i--) {
			returnValue = returnValue + s.substring(i - 1, i);
		}

		return returnValue;
	} // end of reverse()

}