package algoprep;

import java.util.Scanner;

public class MaxDifference4 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int ar[] = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = scanner.nextInt();
        }
        int max1 = maxdifference_2(ar);
       int max2 = maxdifference_3(ar);
        System.out.println(Math.max(max1,max2));
        scanner.close();
    }
 public static int maxdifference_2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + i;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }
     for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - i;
        }
        return max - min;
    }
    public static int maxdifference_3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - i;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return max - min;
    }

}
