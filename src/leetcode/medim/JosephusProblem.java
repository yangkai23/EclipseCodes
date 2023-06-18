package leetcode.medim;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class JosephusProblem {
	public static void main(String[] args) {
		int n = 5, k = 3;

		System.out.println(findTheWinner(n, k));
	}

	public static int findTheWinner(int n, int k) {
		ArrayList<Integer> track = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			track.add(i);
		return findFinalPerson(track, 0, k, 0);
	}

	static int findFinalPerson(ArrayList<Integer> track, int pointer, int position, int count) {
		if (count == track.size() - 1)
			return track.get(pointer - 1);
		int c = position;
		while (pointer < track.size() && c > 0) {

			while (track.get(pointer) == Integer.MIN_VALUE) {
				System.out.println(pointer);
				pointer++;
			}
			pointer++;
			c--;
		}
		pointer--;
		System.out.println(pointer);
		while (pointer >= track.size()) {
			pointer = pointer - track.size();
		}
		System.out.println(track + "   before");
		track.set(pointer, Integer.MIN_VALUE);
		System.out.println(track + "   after");
		return findFinalPerson(track, pointer + 1, position, count + 1);
	}

}
