package numerical;

import java.util.Arrays;
import java.util.List;

public class ArrayCheck {
public static void main(String[] args) {
	int ar[]=new int [2];
	ar[0]=4;ar[1]=65;
	int a[]= getArray(ar);
}

private static int[] getArray(int []ar) {
	List<int[]> a=Arrays.asList(ar);
	System.out.println(a.get(0));
	return null;
}
}
