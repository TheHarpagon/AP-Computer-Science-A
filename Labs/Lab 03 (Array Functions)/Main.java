class Main {
	public static void main(String[] args) {
		int[] b = {1,0,3,0,0,6,7,0,9,10};
		System.out.println(sum(b));
		System.out.println(countZero(b));
		System.out.println(b);
		printArray(b);
		printArray(b);
		int [] c = {1,2,3};
		int [] d = copy(c);
		d[1] = 0;
		printArray(c); // {1,2,3}
		printArray(d); // {1,0,3}
	} // end of main()
  
	public static int sum(int[] a) {
		int rv = 0;
		for (int i = 0; i < a.length; i++)
			rv += a[i];
		return rv;
	} // end of sum()
  
	public static int countZero(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] == 0)
				count++;
		return count;
	} // end of countZero()

	public static int countPositive(int[] a){
		int count = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] > 0)
		  	count ++;
		return count;
	} // end of countPositive()
  
	public static int countNegative(int[] a){
		int count = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] < 0)
				count ++;
		return count;
	} // end of countNegative()
  
	public static void printArray(int[] a) {
		System.out.println(arrayToString(a));
	} // end of printArray()
	  
	public static String arrayToString(int[] a) {
		String rv = "{";
  
		for (int i = 0; i < a.length; i++)
			if (i==0) // if a.length - 1
				rv += a[0];
			else
				rv += ", " + a[i];
		rv += "}";
		return rv;
	} // end of arrayToString()
  
	public static int[] badCopy(int[] a) {
		int[] b;
		b = a;
		return b;
	} // end of badCopy()
  
	public static int[] copy(int[] a) { //  {1,2,3}
		int[] b = new int[a.length];      // {?,?,?}
		for (int i = 0; i < b.length; i++)
			b[i] = a[i];
		return b;
	} // end of copy()
  
	public static int[] bigger(int[] a) { // {1,2,3}
		// {1,2,3,} → {1,2,3,0}
		int[] rv = new int[a.length + 1]; //  {?,?,?,?}
		for (int i = 0; i < a.length; i++)
			rv[i] = a[i];
		rv[rv.length - 1] = 0;
		return rv;
	} // end of bigger()
  
	public static int [] splitDigits(int a ) {
		int[] rv;
		int digits = 0;
		int copyA = a;
		while (copyA > 0) {
			copyA /= 10;
			digits ++;
		}
		rv = new int[digits];
		for (int i = 0; i < digits; i++) {
			rv[i] = a % 10;
			a /= 10;
		}
		return rv;
	} // end of splitDigits()

  }