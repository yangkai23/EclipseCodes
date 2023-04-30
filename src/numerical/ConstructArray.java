package numerical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConstructArray {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	List<Integer> A = new ArrayList<>();
	for (int i = 0; i < n; i++) {
		A.add(sc.nextInt());
	}
	int r=maxSkillLevel(n,A);
	System.out.println(r);
	sc.close();
}

private static int maxSkillLevel(int N, List<Integer> A) {
		int index=2;
		int sum=A.get(index);
		++index;
		while(index!=2) {
			sum=sum+getXorSum(index, A);
			index++;
			if(index==A.size()) {
				index=0;
			}
		}
	return sum;
}
public static int getXorSum(int x,List<Integer> A) {
	int i=x,sum=0;
	while(i>=0) {
		if(i>0)
	sum=sum^A.get(i);
		i--;
	}
	return sum;
}
}
