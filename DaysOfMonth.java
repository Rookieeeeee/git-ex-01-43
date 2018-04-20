/*
 * DaysOfMonth.java
 *  Print number of days in a given month and year.
 *
 * Compile it: % javac DaysOfMonth.java
 * and exec. : % java DaysOfMonth 2019 4
 *
 */

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class DaysOfMonth {
    public static void main(String[] args){
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        // Buggy output
        try {
            System.out.printf("Month of %d/%d has %d days\n",
            		month, year, daysofmonth(month, year));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    static int daysofmonth(int month, int year) throws IOException {
        if ( month < 1 || month > 12 ) {
            throw new IOException("Please Input 1 <= month <= 12");
        } else if ( year < 0 ) {
            throw new IOException("Please Input year >= 0");
        }

        List<Integer> day_31 = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        List<Integer> day_30 = new ArrayList<Integer>(Arrays.asList(4, 6, 9, 11));

        if ( day_31.contains(month) ) {
            return 31;
        } else if ( day_30.contains(month) ) {
            return 30;
        } else {
            if ( year % 100 == 0 && year % 400 != 0 ) {
                return 28;
            } else if ( year % 4 == 0 ) {
                return 29;
            } else {
                return 28;
            }
        }
    }
}
