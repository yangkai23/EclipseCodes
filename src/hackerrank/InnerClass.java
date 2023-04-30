package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InnerClass {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		Object o;// Must be used to hold the reference of the instance of the class
					// Solution.Inner.Private
		// o=new Object();
		InnerClass.Inner inner = new InnerClass.Inner();
		o = inner.new Private();
		Inner.Private pprivate = (Inner.Private) o;
		System.out.println(num + " is " + pprivate.powerof2(num));
		// Write your code here

		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

	}// end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

}// end of Solution
