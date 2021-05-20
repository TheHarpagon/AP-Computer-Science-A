// 1A
public static int numberOfLearYears(int year1, int year2) {
	int rv = 0;
	for (int i = year1; i <= year2; i++) {
		if (isLeapYear(i))
			rv++;
	}
	return rv;
}

// 1B
public static int dayOfWeek(int month, int day, int year) {
	return dayOfYear(month, day, year) + firstDayOfYear(year) - 1; 
 }

// 2
public class StepTracker {
	private int activeThreshold;
	private ArrayList<Integer> dailySteps;
	
	public StepTracker(int activeThreshold) {
		this.activeThreshold = activeThreshold;
		dailySteps = new ArrayList<Integer>();
	}
	
	public void addDailySteps(int steps) {
		dailySteps.add(steps);
	}
	
	public int activeDays() {
		int rv = 0;
		for (int i : dailySteps) {
			if (i >= activeThreshold)
				rv++;
		}
		return rv;
	}
	
	public double averageSteps() {
		int total = 0;
		for (int i : dailySteps)
			total += i;
		return (double) total / dailySteps.size();
	}
}

// 3A
public ArrayList<String> getDelimitersList(String[] tokens) {
	ArrayList<String> rv = new ArrayList<String>();
	for (String i : tokens) {
		if (i.equals(openDel) || i.qeuals(closeDel))
			rv.add(i);
	}
	return rv;
}

// 3B
public boolean isBalanced(ArrayList<String> delimiters) {
	int openDelCount = 0;
	int closeDelCount = 0;
	for (int i = 0; i < delimiters.size(); i++) {
		for (int j = 0; j <= i; j++) {
			if (delimiters.get(j).equals(openDel))
				openDelCount++;
			else
				closeDelCount++;
		}
		if (closeDelCount > openDelCount)
			return false;
	}

	openDelCount = 0;
	closeDelCount = 0;

	for (String i : delimiters) {
		if (i.equals(openDel))
			openDelCount++;
		else
			closeDelCount++;
	}
	return openDelCount == closeDelCount;
}

// 4A
public LightBoard(int numRows, int numCols) {
	lights = new boolean[numRows][numCols];
	for (boolean[] i : lights) {
		for (boolean j : i) {
			if ((int) (Math.random() * 10) <= 3)
				j = true;
			else
				j = false;
		}
	}
}

// 4B
public boolean evaluateLight(int row, int col) {
	int on = 0;
	for (int[] i : lights) {
		if (i[col])
			on++;
	}
	
	if (lights[row][col])
		if (on % 2 == 0)
			return false;
	
	else
		if (on % 3 == 0)
			return true;
	
	return lights[row][col];
}