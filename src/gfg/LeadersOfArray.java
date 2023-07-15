package gfg;

public class LeadersOfArray {
	public static void main(String[] args) {
		int arr[] = { 15, 1, 3, 4, 2 };
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {
		int currentLeader = arr[arr.length - 1];
		System.out.println(currentLeader);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (currentLeader < arr[i]) {
				currentLeader = arr[i];
				System.out.println(currentLeader);
			}
		}
	}
}
