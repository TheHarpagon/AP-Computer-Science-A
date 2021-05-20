class Main {
    public static void main (String[] args) {
        Time t = new Time(); // midnight (12:00:00 AM)
        t.h = 0;
        t.m = 2;
        t.s = 3;
        t.isAM = false;
        // 12:02:03 PM
        String s = timeToString(t);
        System.out.println(timeToString(t));
        System.out.println(timeToSeconds(t)); // 123s
        Time start = new Time(8, 30, 0, true);
        Time end = new Time(3, 6, 0, false);
        System.out.println(timeToSeconds(end) - timeToSeconds(start));
    }
    
    public static int timeToSeconds (Time t) {
        int rv = 0;
        rv = t.h * 3600; // hour(s) conversion
        rv += t.m * 60; //  minute(s) conversion
        rv += t.s; // second(s) conversion
        if (t.isAM == false)
            rv += 12 * 3600;
        return rv;
    }
    
    public static String timeToString (Time t) {
        String rv = "";
        if (t.h == 0)
            rv = "12:";
        else
            rv = t.h + ":";
        if (t.m < 10)
            rv += "0";
        rv += t.m + ":";
        if (t.s < 10)
            rv += "0";
        rv += t.s;
        if (t.isAM)
            rv += " AM";
        else
            rv += " PM";
        return rv;
    }
}