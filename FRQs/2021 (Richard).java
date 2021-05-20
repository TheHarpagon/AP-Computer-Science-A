// https://apcentral.collegeboard.org/pdf/ap21-frq-computer-science-a.pdf

// 1A
public int scoreGuess(String guess) {
	int count = 0;
	for (int i = 0; i < secret.length()-guess.length() + 1; i++)
			if (guess.compareTo(secret.substring(i, i + guess.length())) == 0)
					count ++;
	return count * guess.length() * guess.length();
}

// 1B
public String findBetterGuess(String guess1, String guess2) {
	int first = scoreGuess(guess1);
	int second = scoreGuess(guess2);
	if (first > second)
			return guess1;
	else if (first < second)
			return guess2;
	else {
		if (guess1.compareTo(guess2) > 0)
			return guess1;
		else
			return guess2;
	}
}

// 2
public class ConbinedTable{
	private int seats;
	private double desirability;
	
	public ConbinedTable(SingleTable t1, SingleTable t2){
		seats = (t1.getNumSeats() + t2.getNumSeats() - 2);
		if (t1.getHeight() == t2.getHeight())
			desirability = t1.getViewQuality() / t2.getViewQuality();
		else
			desirability = t1.getViewQuality() / t2.getViewQuality() - 10;
	}

	public boolean canSeat(int num) {
		 return num >= seats;
	}

	public boolean getDesirability() {
		return desirability;
	}
}


// 3A
public void addMembers(String[] names, int gradYear) {
	for(String s: names)
		// Assuming no need to instantiate memberList
		memberList.add(new MemberInfo(s, gradYear, true);
}

// 3B
public ArrayList<MemberInfo> removeMembers(int year) {
	ArrayList<MemberInfo> rv = new ArrayList<MemberInfo>();
	for (int i = 0; i < memberList.size(); i++) {
		member = memberList.get(i);
		if (member.getGradYear() <= year)
			if (member.inGoodStanding())
				rv.add(member);
			memberList.remove(i);
			i--;
	}
	return rv;
}

// 4A
public static boolean isNonZeroRow(int[][] array2D, int r) {
	int[] a = array2D[r];
	for (int num: a)
		if(num == 0)
			return false;
	return true;
}

// 4B
public static int[][] resize(int[][] array2D) {
	int numRows = numNonZeroRows(array2D);
	int[][] smaller = new int[numRows][array2D[0].length];
	int j = 0;
	for (int i = 0; i < array2D.length; i++) {
		if (isNonZeroRow(array2D, i)
			smaller[j] = array2D[i];
			j++;
	}
	return smaller;
}