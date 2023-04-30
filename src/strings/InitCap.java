package strings;

import java.util.*;
import java.util.stream.*;

public class InitCap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String resultString = getInitString(input);
        System.out.println(resultString);
        scanner.close();
    }

    private static String getInitString(String input) {
        String[] array = input.split("\\s");
        for (int i = 0; i < array.length; i++) {
            if (isUpperCaseLetter(array[i].charAt(0))) continue;
            else if (isLowerCaseLetter(array[i].charAt(0)))
                array[i] = (char) (array[i].charAt(0) - 32) + array[i].substring(1, array[i].length());
            else continue;
        }
        return Arrays.stream(array).map(i -> i + " ").collect(Collectors.joining()).toString().trim();
    }

    public static boolean isUpperCaseLetter(char ch) {
        return ch >= 65 && ch <= 90;
    }

    public static boolean isLowerCaseLetter(char ch) {
        return ch >= 97 && ch <= 122;
    }
}
