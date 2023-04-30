package numerical;

import java.util.Scanner;

public class AutoMorphicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isAutoMorphicNumber(num) ? num + " is an AutoMorphic Number" : num + " is Not an AutoMorphic Number");
        scanner.close();
    }
    public static boolean isAutoMorphicNumber(int num) {
        return Math.pow(num, 2) % Math.pow(10, String.valueOf(num).length()) == num;
    }
}
