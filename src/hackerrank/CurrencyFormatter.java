package hackerrank;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
	
static {Class  tclass=new CurrencyFormatter().getClass();
System.out.println(tclass.getDeclaredMethods()[0].getName());

}
	public static void main(String[] args) {
		// Locale for India
		Locale indianLocale = new Locale("en", "IN");
		Locale usLocale = Locale.US;
		Locale chinaLocale = Locale.CHINA;
		Locale franceLocale = Locale.FRANCE;
		double n = 0.999;
		String us = NumberFormat.getCurrencyInstance(usLocale).format(n);
		String india = NumberFormat.getCurrencyInstance(indianLocale).format(n);
		String france = NumberFormat.getCurrencyInstance(franceLocale).format(n);
		String china = NumberFormat.getCurrencyInstance(chinaLocale).format(n);
		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}
}
