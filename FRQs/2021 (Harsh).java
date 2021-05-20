// https://apcentral.collegeboard.org/pdf/ap21-frq-computer-science-a.pdf

// 1A
public int scoreGuess(String guess) {
	int occur = 0;
	for (int i = 0; i < secret.length(); i++) {
		if (secret.substring(i, i + guess.length())) {
			occur++;
		}
	}
	return occur * Math.pow(guess.length(), 2);
}

// 1B
public String findBetterGuess(String guess1, String guess2) {
	if (scoreGuess(guess1) < scoreGuess(guess2))
		return guess1;
	else if (scoreGuess(guess1) > scoreGuess(guess2))
		return guess2;
	else
		if (guess1.compareTo(guess2) > 0)
			return guess1;
		else
			return guess2;
}

// 2
public class CombinedTable {
	private SingleTable a;
	private SingleTable b;
	private int seats;
	
	public CombinedTable(SingleTable a, SingleTable b) {
		this.a = a;
		this.b = b;
		seats = a.getNumSeats() + b.getNumSeats() - 2;
	}
	
	public boolean canSeat(int people) {
		return people <= seats;
	}
	
	public double getDesirability() {
		if (a.getHeight() == b.getHeight()) 
			return (double) (a.getViewQuality + b.getViewQuality) / 2;
		else
			return ((double) (a.getViewQuality + b.getViewQuality) / 2) - 10;
	}
}

// 3A
public void addMembers(String[] names, int gradYear) {
	for (String i : names)
		memberList.add(new MemberInfo(i, gradYear, true));
}

// 3B
public ArrayList<MemberInfo> removeMembers(int year) {
	ArrayList<MemberInfo> graduated = new ArrayList<MemberInfo>();
	for (int i = 0; i < memberList.size(); i++) {
		if (memberList.get(i).getGradYear() <= year)
			memberList.remove(memberList.get(i));
			i--;
			if (memberList.get(i).inGoodStanding())
				graduated.add(memberList.get(i));
	}
	return graduated;
}

// 4A
public static boolean isNonZeroRow(int[][] array2D, int r) {
	for (int i : array2D[r]) {
		if (i == 0)
			return false;
	}
	return true;
}

// 4B
public static int[][] resize(int[][] array2D) {
	int[][] rv = new int[numNonZeroRows(array2D)][array2D[0].length];
	int currRow = 0;
	int currColumn = 0;
	for (int i = 0; i < array2D.length; i++) {
		if (isNonZeroRow(array2D, i))
			for (int j : array2D[i]) {
				rv[currRow][currColumn] = j;
				currColumn++;
			}
			currRow++;
			currColumn = 0;
	}
	return rv;
}