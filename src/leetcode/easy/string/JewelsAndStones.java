package leetcode.easy.string;

import java.util.HashMap;

public class JewelsAndStones {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("z", "ZZ"));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		HashMap<Character, Integer> stoneCount = new HashMap<>();
		for (char stone : stones.toCharArray()) {
			stoneCount.put(stone, stoneCount.getOrDefault(stone, 0) + 1);
		}
		int jewelCount = 0;
		for (char jewel : jewels.toCharArray())
			jewelCount += stoneCount.getOrDefault(jewel, 0);
		return jewelCount;
		
		
		/*  0 ms solution
		 * int num = 0; for (int i = 0 ; i < stones.length(); i ++) {
		 * if(jewels.indexOf(stones.charAt(i)) != -1) { num++; } } return num;
		 */
	}
}
