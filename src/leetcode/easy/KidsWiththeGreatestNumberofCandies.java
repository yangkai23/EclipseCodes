package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {
	public static void main(String[] args) {
		int[] candies = { 4, 2, 1, 1, 2 };
		int extraCandies = 1;
		System.out.println(kidsWithCandies(candies, extraCandies));
	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		ArrayList<Boolean> list = new ArrayList<>();
		int max = candies[0];
		for (int i = 1; i < candies.length; i++) {
			if (candies[i] > max) {
				max = candies[i];
			}
		}
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max)
				list.add(true);
			else
				list.add(false);
		}
		return list;
	}
}
