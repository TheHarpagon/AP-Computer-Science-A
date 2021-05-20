public class Time {
    // hours go from 0 - 11, not 1 - 12
    public int h, m, s;
    public boolean isAM;
    
    // Constructors
    public Time () {
        // initialization and data validation
        h = 0;
        m = 0;
        s = 0;
        isAM = true;
    }

    public Time (int hour, int minute, int second, boolean am){
        if (hour == 12)
            h = 0;
        else
            h = hour;
        m = minute;
        s = second;
        isAM = am;
    }
}