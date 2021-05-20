public class Main {
    public static void main (String[] args) {
        System.out.println("Lab #12 (Date Class)\n");
        
        Date birthDate = new Date (8, 14, 2004);
        System.out.println("String dateToString (Date date): \n" + Date.dateToString(birthDate) + "\n");
        
        Date dateA1 = new Date (5, 1, 2019);
        Date dateA2 = new Date (1, 1, 2020);
        Date dateB1 = new Date (1, 1, 2020);
        Date dateB2 = new Date (5, 1, 2020);
        Date dateC1 = new Date (1, 1, 2015);
        Date dateC2 = new Date (1, 1, 2020);
        System.out.println("int daysInBetween (Date date1, Date date2): ");
        System.out.println("A) From " + Date.dateToString(dateA1) +  " to " + Date.dateToString(dateA2) + " (" + daysInBetween(dateA1, dateA2) + " days)");
        System.out.println("B) From " + Date.dateToString(dateB1) +  " to " + Date.dateToString(dateB2) + " (" + daysInBetween(dateB1, dateB2) + " days)");
        System.out.println("C) From " + Date.dateToString(dateC1) +  " to " + Date.dateToString(dateC2) + " (" + daysInBetween(dateC1, dateC2) + " days)\n");
        
        System.out.println("int ageInMinutes (Date birthDate, Date currentDate): \nYou are " + ageInMinutes(birthDate, new Date (12, 5, 2020)) + " Minutes Old!");
    }

    public static boolean isLeapYear (Date date) {
        if (date.year % 100 == 0 && date.year % 400 == 0) {
            return true;
        }
        
        else if (date.year % 4 == 0) {
            return true;
        }

        else {
            return false;
        }
    }

    public static int daysInBetween (Date date1, Date date2) {
        int rv = 0;
        // amount of days in each month (from January to December)
        int[] dayCount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // declaration of days between current day and last day of the month
        rv = dayCount[date1.month - 1] - date1.day;
        
        // conditional for adding an extra day on an instance of a leap year
        if (isLeapYear(date1) && date1.month >= 2)
            rv++;
        
        // conditional for mismatching years
        if (date1.year != date2.year) {
            // loop for adding all the days of that year
            for (int i = date1.month; i < 12; i++) {
                rv += dayCount[i];
            }
            
            // loop for skipping a year by simply adding 366 or 365
            for (int i = date1.year + 1; i < date2.year; i++) {
                if (isLeapYear(new Date(1, 1, i))) {
                    rv += 366;
                }
                else {
                    rv += 365;
                }
            }
            
            // loop for adding days up till date2.month
            for (int i = 0; i < date2.month - 1; i++) {
                rv += dayCount[i];
            }
            rv += date2.day - 1;
        }
        
        else {
            for (int i = date1.month; i < date2.month - 1; i++) {
                rv += dayCount[i];
            }
        }

        // adds an extra day if the date is a leap year and passes February
        if (date2.month >= 2 && isLeapYear(date2))
            rv++;
        return rv;
    }

    public static int ageInMinutes (Date birthDate, Date currentDate) {
        return daysInBetween(birthDate, currentDate) * 1440;
    }
}