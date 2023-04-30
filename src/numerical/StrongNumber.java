package numerical;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isStrongNumber(num) ? "Strong Number" : "Not Strong Number");
        scanner.close();
    }

    private static boolean isStrongNumber(int num) {
        int temp = num, sum = 0;
        do {
            sum += factorial(num % 10);
            num /= 10;
        } while (num != 0);

        return temp == sum;
    }

    private static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num - 1);
    }
}
