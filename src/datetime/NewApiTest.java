package datetime;

import java.time.LocalDate;
import java.time.Month;

public class NewApiTest {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2023, Month.APRIL, 17);
		System.out.println(localDate);
		System.out.println(localDate.plusMonths(20));
		System.out.println(localDate.getDayOfYear());

	}
}
