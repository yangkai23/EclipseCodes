package hackerrank;

import java.util.Calendar;
import java.util.Locale;

public class CalenderTest {
	public static void main(String[] args) {
		String day=findDay(8, 05, 2015);
		System.out.println(day);
	}
	 public static String findDay(int month, int day, int year) {
         Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.UK).toUpperCase();
       
 }
}
