package gfg;

import java.util.LinkedList;

public class ArraySubsets {
	public static void main(String[] args) {
		int ar[] = { 1, 2, 3, 4 };
		printArrSubsets(ar);
	}

	private static void printArrSubsets(int[] ar) {
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println(list);
		printArrSubsets(ar, -1, list);
	}

	private static void printArrSubsets(int[] ar, int i, LinkedList<Integer> list) {
		i++;
		if (i == ar.length)
			return;
		printArrSubsets(ar, i, add(ar[i], list));
		System.out.println(list);
		list.removeLast();
		printArrSubsets(ar, i, list);
	}

	private static LinkedList<Integer> add(int num, LinkedList<Integer> list) {
		list.add(num);
		return list;
	}
}
