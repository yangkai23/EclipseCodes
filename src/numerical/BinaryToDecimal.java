package numerical;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int binary = scanner.nextInt();
        int result = getDecimalNumber(binary);
        System.out.println(result);
        scanner.close();
    }

    private static int getDecimalNumber(int binary) {
        int decimal = 0, count = 0;
        do {
            decimal += (int) Math.pow(2, count++) * (binary % 10);
            binary /= 10;
        } while (binary != 0);

        double[] gpa = {1, 2, 1, 3};
        int[] val = Arrays.stream(gpa).filter(i -> (i >= 3.2 && i <= 3.5)).mapToInt(i->(int)i).toArray();
        return decimal;
    }
}
