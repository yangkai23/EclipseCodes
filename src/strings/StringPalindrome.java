package strings;

import java.util.*;
import java.util.stream.Collectors;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(isPalindromeByStack(input));
        scanner.close();
    }

    public static boolean isPalindromeByRegularLoop(String input) {
        String st = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            st += input.charAt(i);
        }
       /* String str="";
        for(int i=0;i<str.length();i++){
            str=input.charAt(i)+str;
        }
        return str.equals(input);*/
        return input.equals(st);
    }

    public static boolean isPalindromeByStreamAPI(String input) {

        Object[] array = input.chars().mapToObj(i -> (char) i).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list);
            return list;
        })).toArray();
        String st = "";
        for (Object obj : array)
            st += obj;
        return input.equals(st);
    }

    public static boolean isPalindromeByArrayElementsSwap(String input) {
        char[] array = input.toCharArray();
        for (int i = 0; i < input.length() / 2; i++) {
            char temp = array[i];
            int swapPos = input.length() - 1 - i;
            array[i] = array[swapPos];
            array[swapPos] = temp;
        }
        return String.valueOf(array).equals(input);
    }

    public static boolean isPalindromeByStack(String input) {
        Stack<Character> stack = new Stack<>();
        for (char Char : input.toCharArray())
            stack.push(Char);
        String st = "";
        for (Character character : stack)
            st += character;
        return input.equals(st);
        /*String res="";
        for(char ch:input.toCharArray()){
           stack.push(ch);
           res=stack.pop()+res;
        }
        return res.equals(input);*/
    }

    public static boolean isPalindromeByStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString().equals(input);
    }

    public static boolean isPalindromeByArrayElementsCompare(String input) {
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) return false;
        }
        return true;
    }
}
