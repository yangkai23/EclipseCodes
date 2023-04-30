package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayElementManipulationANDSort {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int[] first = readArray();
        int[] second = readArray();
        System.out.println("insertionIndex");
        int insertionIndex = scanner.nextInt();
        System.out.println("newElement");
        int newElement = scanner.nextInt();
        System.out.println("deletionIndex");
        int deletionIndex = scanner.nextInt();
        int[] result = getFinalArray(insertionIndex, newElement, deletionIndex, first, second);
        System.out.println(Arrays.toString(result));

        scanner.close();
    }

    private static int[] getFinalArray(int insertionIndex, int newElement, int deletionIndex, int[] first, int[] second) {
        int[] insertionArray = new int[first.length + 1];
        int[] deletionArray = new int[second.length - 1];
        if (insertionIndex != 0) System.arraycopy(first, 0, insertionArray, 0, insertionIndex);
        insertionArray[insertionIndex] = newElement;
        System.arraycopy(first, insertionIndex, insertionArray, insertionIndex + 1, first.length - insertionIndex);
        if (deletionIndex != 0) System.arraycopy(second, 0, deletionArray, 0, deletionIndex);
        System.arraycopy(second, deletionIndex + 1, deletionArray, deletionIndex, second.length - deletionIndex - 1);
        int[] resultantArray = new int[insertionArray.length + deletionArray.length];
        System.arraycopy(insertionArray, 0, resultantArray, 0, insertionArray.length);
        System.arraycopy(deletionArray, 0, resultantArray, insertionArray.length, deletionArray.length);
        sort(resultantArray, 0, resultantArray.length);
        resultantArray = removeDuplicates(resultantArray);
        return resultantArray;
    }

    private static void sort(int[] resultantArray, int start, int end) {
        if (end - start < 2) return;
        int mid = (start + end) / 2;
        sort(resultantArray, start, mid);
        sort(resultantArray, mid, end);
        merge(resultantArray, start, end, mid);
    }

    private static void merge(int[] resultantArray, int start, int end, int mid) {
        if (resultantArray[mid - 1] <= resultantArray[mid]) return;
        int[] array = new int[end - start];
        int i = start;
        int j = mid;
        int position = 0;
        while (i < mid && j < end) {
            array[position++] = resultantArray[i] < resultantArray[j] ? resultantArray[i++] : resultantArray[j++];
        }
        System.arraycopy(resultantArray, i, resultantArray, start + position, mid - i);
        System.arraycopy(array, 0, resultantArray, start, position);
    }

    public static int[] removeDuplicates(int[] array) {
        int index = 0;
        int[] newArray = array;
        while (index < array.length - 1) {
            int duplicateSkip = 0;
            while (array[index] == array[index + 1]) {
                duplicateSkip++;
                index++;
            }
            if (duplicateSkip > 0) {
                newArray = new int[array.length - duplicateSkip];
                if (index != 0) System.arraycopy(array, 0, newArray, 0, index - duplicateSkip + 1);
                if (index < array.length)
                    System.arraycopy(array, index + 1, newArray, index - duplicateSkip + 1, array.length - index - 1);
            }
            array = newArray;
            if (duplicateSkip != 0) continue;
            index++;
        }
        return array;
    }

    public static int[] readArray() {
        System.out.println("Enter size");
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;

    }

}
