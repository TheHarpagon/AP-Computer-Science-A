public class Date {
    public int month;
    public int day;
    public int year;

    public Date () {
        this.day = 0;
        this.month = 0;
    }

    public Date (int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public static String monthName (Date date) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[date.month - 1];
    }

    public static String dateToString (Date date) {
        return monthName(date) + " " + date.day + ", " + date.year;
    }
}